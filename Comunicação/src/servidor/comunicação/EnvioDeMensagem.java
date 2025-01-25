package servidor.comunicação;

public class EnvioDeMensagem implements Runnable {
	String mensagem;
	boolean temMensagem;
	
	@Override
	public void run() {
		temMensagem = false;
		
		
	}
	
	public void Enviar() {
		if (temMensagem) {
			temMensagem = false;
			
		}
	}
}
