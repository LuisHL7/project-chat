import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ServidorChat {
    static final int MAXIMO = 2;//MAXIMO DE CONEXIONES PERMITIDAS

    public static void main(String args[]) throws IOException {
        int PUERTO = 44444;
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado...");
        List<Socket> tabla = new ArrayList<>(MAXIMO);//para controlar las conexiones
        ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);
        do {
            if (comun.getACTUALES() < MAXIMO) {
                if(servidor.isClosed()){
                    servidor = new ServerSocket(PUERTO);
                }
                Socket socket = new Socket();
                socket = servidor.accept();// esperando cliente
                comun.addTabla(socket, comun.getCONEXIONES());
                comun.setACTUALES(comun.getACTUALES() + 1);
                comun.setCONEXIONES(comun.getCONEXIONES() + 1);
                HiloServidorChat hilo = new HiloServidorChat(socket, comun);
                hilo.start();
            } else {
                servidor.close();
            }
        } while (comun.getCONEXIONES() > 0);

    }//main
}//ServidorChat..  

