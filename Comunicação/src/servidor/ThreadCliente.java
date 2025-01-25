package servidor;
 
import java.util.Scanner;

import servidor.comunicação.*;

import java.io.*;
import java.net.*;

public class ThreadCliente implements Runnable {
	private Socket cliente;
	private int identidade;
	private String nome;
	
	public ThreadCliente(Socket cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
		try (
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
		) {
			this.setNome();
			System.out.println("Chat Aberto ;)\n");
			
			while (true) {
				// parte do envio e recebimento de mensagens
				// criar threads para o receber e para enviar as mensagens
				
				
			}
		} 
		catch (IOException e) {
			System.err.println("Falha na comunicação com cliente: " + e.getMessage());
		} 
		finally {
			try {
				this.cliente.close();
			} 
			catch (IOException e) {
				System.err.println("Falha no fechamento do cliente: " + e.getMessage());
			}
		}
	}
	
	public boolean ativo() {
		return cliente.isConnected();
	}
	
	public boolean inativo() {
		return cliente.isClosed();
	}
	
	public void setIdentidade(int id) {
		this.identidade = id;
	}
	
	public int getIdentidade() {
		return this.identidade;
	}
	
	public boolean remover() {
		try {
			this.cliente.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private void setNome() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		this.nome = scanner.next();
	}
}
