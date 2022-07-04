import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ComunHilos {	
	 int CONEXIONES; //N� DE CONEXIONES TOTALES, OCUPADAS EN EL ARRAY
	 int ACTUALES;   //N�MERO DE CONEXIONES ACTUALES
	 int MAXIMO;     //M�XIMO DE CONEXIONES PERMITIDAS	
	 List<Socket> tabla = new ArrayList<>(MAXIMO);// SOCKETS CONECTADOS
	 String mensajes; //MENSAJES DEL CHAT
	
	public ComunHilos(int maximo, int actuales, int conexiones,
					  List<Socket> tabla) {
		MAXIMO = maximo;	 
		ACTUALES = actuales; 
		CONEXIONES = conexiones;	
		this.tabla = tabla;  
		mensajes="";        
	}

	public ComunHilos() { super(); }

     public int getMAXIMO() { return MAXIMO;	}
	public void setMAXIMO(int maximo) { MAXIMO = maximo;}


	public int getCONEXIONES() { return CONEXIONES;	}
	public synchronized void  setCONEXIONES(int conexiones) {
		CONEXIONES = conexiones;
	}

	public String getMensajes() { return mensajes; }
	public synchronized void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	
	public int getACTUALES() { return ACTUALES; }
	public synchronized void setACTUALES(int actuales) {
		ACTUALES = actuales;
	}

	public synchronized void addTabla(Socket s, int i) {		
		tabla.add(s);
	}	
	public Socket getElementoTabla(int i) { return tabla.get(i); }
		
}//ComunHilos
