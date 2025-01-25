package servidor.comunicação;

import java.io.*;
import java.net.*;

public class RecebimentoDeMensagem implements Runnable {
	private ServerSocket servidor;
	
	public RecebimentoDeMensagem(ServerSocket servidor) {
		this.servidor = servidor;
	}
	
	@Override
	public void run() {
		try (
			//BufferedReader entrada = new BufferedReader(new InputStreamReader(System.))
		) {
			return;
		}
		catch (IOException e) {
			return;
		}
	}

}
