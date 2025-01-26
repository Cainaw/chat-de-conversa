package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mensagem;
	private JTextField mensagemPorta;
	private JTextField mensagemNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mensagem = new JTextField();
		mensagem.setBounds(151, 175, 167, 35);
		contentPane.add(mensagem);
		mensagem.setColumns(10);
		
		JTextArea mensagens = new JTextArea();
		mensagens.setBounds(147, 34, 277, 117);
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
		
		mensagemPorta = new JTextField();
		mensagemPorta.setBounds(10, 54, 89, 23);
		contentPane.add(mensagemPorta);
		mensagemPorta.setColumns(10);
		
		JTextArea areaPorta = new JTextArea();
		areaPorta.setBounds(15, 180, 105, 22);
		contentPane.add(areaPorta);
		
		JButton botaoPorta = new JButton("...");
		botaoPorta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String porta = mensagemPorta.getText();
				mensagemPorta.setText("");
				areaPorta.append(porta);
			}
		});
		botaoPorta.setBounds(102, 54, 27, 23);
		contentPane.add(botaoPorta);
		
		JLabel lblNewLabel = new JLabel("PORTA:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 34, 63, 14);
		contentPane.add(lblNewLabel);
		
		mensagemNome = new JTextField();
		mensagemNome.setColumns(10);
		mensagemNome.setBounds(10, 128, 89, 23);
		contentPane.add(mensagemNome);
		
		JTextArea areaNome = new JTextArea();
		areaNome.setBounds(15, 221, 105, 22);
		contentPane.add(areaNome);
		
		JButton botaoNome = new JButton("...");
		botaoNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = mensagemNome.getText();
				mensagemNome.setText("");
				areaNome.append(nome);
			}
		});
		botaoNome.setBounds(102, 128, 27, 23);
		contentPane.add(botaoNome);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNome.setBounds(10, 109, 63, 14);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel_1 = new JLabel("Porta:");
		lblNewLabel_1.setBounds(15, 165, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(15, 207, 46, 14);
		contentPane.add(lblNewLabel_2);
		
	}
}
