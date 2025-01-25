package servidor;

import java.io.*;
import java.net.*;

public class GestorDeClientes implements Runnable {
	Socket cliente;
	PrintWriter saida;
	PrintWriter [] lista;
	
	public GestorDeClientes (Socket cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public void run() {
		try (
			BufferedReader entrada = new BufferedReader(new InputStreamReader(this.cliente.getInputStream()));
			PrintWriter saida = new PrintWriter(this.cliente.getOutputStream(), true);
		) {
			this.saida = saida;
			this.adicionarSaida();
			
			String mensagem;
			int indice;
			while ((mensagem = entrada.readLine()) != null) {
				System.out.println(mensagem);
				
				indice = 0;
				for (PrintWriter celula : lista) {
					if (celula != null && saida != lista[indice]) {
						celula.println(mensagem);
					} indice++;
				}
			}
		}
		catch (IOException e) {
			System.err.println("Erro ao criar canal de comunicação: " + e.getMessage());
		}
		finally {
			try {
				cliente.close();
				System.out.println("Cliente fechado com sucesso");
			}
			catch (IOException e) {
				System.err.println("Erro ao fechar o cliente: " + e.getMessage());
			}
		}
	}
	
	public void adicionarLista(PrintWriter [] lista) {
		this.lista = lista;
	}
	
	private boolean adicionarSaida() {
		int indice = 0;
		for (PrintWriter celula : lista) {
			if (celula == null) {
				lista[indice] = saida;
				return true;
			} indice++;
		}
		return false;
	}
}