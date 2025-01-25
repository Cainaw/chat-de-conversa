package servidor;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Servidor {
	static final int NUMERO = 5;
	static final int PORTA = 10000;
	
	static PrintWriter [] saidas = new PrintWriter[NUMERO];
	
	public static void main(String[] args) {
		for (@SuppressWarnings("unused") PrintWriter saida : saidas)
			saida = null;
		
		ExecutorService clientes = Executors.newFixedThreadPool(NUMERO);
		
		try (ServerSocket servidor = new ServerSocket(PORTA)) {
			System.out.println("Servidor iniciado ;)\n");
			while (true) {
				Socket cliente = servidor.accept();
				
				if (cliente.isConnected()) {
					System.out.println("Novo cliente conectado =)");
					GestorDeClientes gestor = new GestorDeClientes(cliente);
					gestor.adicionarLista(saidas);
					clientes.execute(gestor);
					
				}
			}
		} 
		catch (IOException e){
			System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
		}
	}
}