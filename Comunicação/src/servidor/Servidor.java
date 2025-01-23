package servidor;

import java.io.*;
import java.net.*;

public class Servidor {
	public static void main(String[] args) {
		int porta = 10000;
		
		try (ServerSocket servidor = new ServerSocket(porta)) {
			Socket cliente;
			System.out.println("Esperando conexão...\n");
			
			cliente = servidor.accept();
			System.out.println("Cliente conectado\n");
			
			try (
				BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
			) {
				System.out.println("- Chat de comunicação ativo -");
				String mensagem;
				while ((mensagem = entrada.readLine()) != null) {
					System.out.println(mensagem);
					
					if (mensagem.equalsIgnoreCase("sair")) {
						System.out.println("Cliente desconectado...");
						break;
					}
					
					System.out.print("Servidor: ");
					mensagem = teclado.readLine();
					
					saida.println("Servidor: " + mensagem);
				}
				
			}
			catch (IOException e) {
				System.err.println("Erro ao se comunicar com o cliente: " + e.getMessage());
			}
			finally {
				try {
					cliente.close();
					System.out.println("Conexão encerrada");
				}
				catch (IOException e) {
					System.err.println("Erro ao fechar o cliente: " + e.getMessage());
				}
			}
		}
		
		catch (IOException e) {
			System.err.println("Erro ao iniciar o cliente: " + e.getMessage());
		}
		
	}

}
