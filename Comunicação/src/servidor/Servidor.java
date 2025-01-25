package servidor;
 
import servidor.comunicação.*;
import java.io.*;
import java.net.*;

public class Servidor {
	public static void main(String[] args) {
		final int porta = 10000;
		
		
		GestorDeClientes gestor = new GestorDeClientes(5);
		
		try (ServerSocket servidor = new ServerSocket(porta)) {
			
			Socket cliente;
			RecebimentoDeMensagem rec = new RecebimentoDeMensagem(servidor);
			
			while (true) {
				cliente = servidor.accept();
				
				if (cliente.isConnected()) {
					gestor.adicionar(cliente);
				}
				
				
				
			}
			
		}
		
		catch (IOException e) {
			System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
		}
		
	}

}
