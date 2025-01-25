package cliente;

import java.io.*;
import java.net.*;

public class Cliente {
	static final int PORTA = 10000;
	static final String LOCAL = "localhost";
	
	public static void main(String[] args) {
		
		
		
		try (Socket cliente = new Socket(LOCAL, PORTA)) {
			new Thread (() -> {
				try (BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()))) {
					String mensagemServidor;
					while ((mensagemServidor = entrada.readLine()) != null) {
						System.out.println(mensagemServidor);
					}
				}
				catch (IOException e) {
					System.err.println("Desconectado pelo servidor: " + e.getMessage());
					try {
						cliente.close();
					} 
					catch (IOException e1) {
						System.err.println("Erro ao fechar socket: " + e1.getMessage());
					}
					System.out.println("Cliente desconectado");
					return;
				}
			}).start();
			
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
			
			String mensagem;
			while (true) {
				System.out.print("Você: ");
				mensagem =  teclado.readLine();
				
				if (mensagem.equalsIgnoreCase("sair"))
					break;
				
				saida.println("Cliente: " + mensagem);
				
			}
		}
		catch (IOException e) {
			System.err.println("Erro ao iniciar cliente: " + e.getMessage());
		}
	}
}