package cliente;

import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		String endereco = "localhost";
		int porta = 10000;
		
		try (Socket cliente = new Socket(endereco, porta)) {
			System.out.println("Conexão realizada\n");
			
			try (
				BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
			) {
				System.out.println("- Chat de comunicação ativo -");
				String mensagem;
				
				while (true) {
					System.out.print("Você: ");
					mensagem = teclado.readLine();
					
					if (mensagem.equalsIgnoreCase("sair")) {
						saida.println("sair");
						break;
					}
					
					saida.println("Cliente: " + mensagem);
					System.out.println(entrada.readLine());
				}
				
				System.out.println("Conexão fechada");
			}

		}
		catch (UnknownHostException e) {
			System.err.println("Servidor não encontrado");
		}
		catch (IOException e) {
			System.err.println("Erro ao se conectar ao servidor: " + e.getMessage());
		}
	}

}
