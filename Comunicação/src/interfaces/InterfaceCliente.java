package interfaces;

import cliente.Cliente;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mensagem;
	
	private static String nome;
	private static int porta;
	private Cliente cliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if (nome == null || porta <= 1024)
					
				try {
					InterfaceCliente frame = new InterfaceCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mensagem = new JTextField();
		mensagem.setBounds(130, 175, 188, 35);
		contentPane.add(mensagem);
		mensagem.setColumns(10);
		
		JTextArea mensagens = new JTextArea();
		mensagens.setBounds(128, 34, 296, 117);
		contentPane.add(mensagens);
		
		JButton botaoEnviar = new JButton("ENVIAR");
		botaoEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = mensagem.getText();
				mensagem.setText("");
				mensagens.append(texto + "\n");
			}
		});
		botaoEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoEnviar.setBounds(328, 175, 96, 35);
		contentPane.add(botaoEnviar);
		
		JTextArea areaPorta = new JTextArea();
		areaPorta.setBounds(10, 59, 80, 22);
		contentPane.add(areaPorta);
		
		JLabel lblNewLabel = new JLabel("PORTA:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 34, 63, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea areaNome = new JTextArea();
		areaNome.setBounds(10, 134, 80, 22);
		contentPane.add(areaNome);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNome.setBounds(10, 109, 63, 14);
		contentPane.add(lblNome);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(117, 0, 317, 261);
		contentPane.add(panel);
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		InterfaceCliente.nome = nome;
	}

	public static int getPorta() {
		return porta;
	}

	public static void setPorta(int porta) {
		InterfaceCliente.porta = porta;
	}
	
	
}
