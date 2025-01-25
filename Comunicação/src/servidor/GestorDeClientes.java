package servidor;

import java.io.*;
import java.net.*;

public class GestorDeClientes{
	final int tamanho;
	Thread [] clientes;
	
	public GestorDeClientes(int tamanho) {
		this.tamanho = tamanho;
		this.clientes = new Thread[tamanho];
	}
	
	public boolean cheio() {
		return this.clientes.length == this.tamanho;
	}
	
	public boolean adicionar(Socket novoCliente) {
		if (cheio()) {
			try {
				novoCliente.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		ThreadCliente cliente = new ThreadCliente(novoCliente);
		for (int indice = 0; indice < this.tamanho; indice++) {
			if (clientes[indice].isAlive()) {
				this.clientes[indice] = new Thread(cliente);
				cliente.setIdentidade(indice);
				
				this.clientes[indice].start();
				return true;
			}
		}
		return false;
	}
	
	
	// arrumar método
	public boolean remover(int indice) {
		return false;
	}
	
	// arrumar método
	public ThreadCliente getCliente (int id) {
		int indice = 0;
		for (Thread cliente : clientes) {
			if (indice++ == id)
				return null;
		}
		return null;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
}
