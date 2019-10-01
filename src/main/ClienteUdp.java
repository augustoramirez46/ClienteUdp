package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

public class ClienteUdp extends Observable implements Runnable{
	
	private DatagramSocket s;
	
	public ClienteUdp() {
		try {
			s = new DatagramSocket();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
	}

	public void enviado(String mensaje) throws IOException {
	
        //buffer donde se almacenara los mensajes
        byte[] buffer = mensaje.getBytes();
        
          //Obtengo la localizacion de localhost
            InetAddress direccionServidor = null;
			try {
				direccionServidor = InetAddress.getByName("192.168.114.12");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            //Creo un datagrama
            DatagramPacket p = new DatagramPacket(buffer, buffer.length, direccionServidor, 5000);
 
            //Lo envio con send
            System.out.println("Envio el datagrama");
            s.send(p);
 

	}
	}