package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceConexao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoNome;
	private JTextField textoPorta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceConexao frame = new InterfaceConexao();
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
	public InterfaceConexao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textoNome = new JTextField();
		textoNome.setBounds(54, 89, 141, 41);
		contentPane.add(textoNome);
		textoNome.setColumns(10);
		
		textoPorta = new JTextField();
		textoPorta.setBounds(234, 89, 141, 41);
		contentPane.add(textoPorta);
		textoPorta.setColumns(10);
		
		JButton enviarDados = new JButton("Enviar Dados");
		enviarDados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enviarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String portaString = textoPorta.getText();
				textoPorta.setText("");
				int porta;
				
				String nome = textoNome.getText();
				try {
					porta = Integer.valueOf(portaString);
					try {
						InterfaceCliente inter = new InterfaceCliente();
						inter.setVisible(false);
						InterfaceCliente.setNome(nome);
						InterfaceCliente.setPorta(porta);
						try {
							inter.setVisible(true);
							dispose();
						}
						catch (Exception erro) {
							JOptionPane.showMessageDialog(null, "Porta não encontrada ou inexistente");
						}
					}
					catch (Exception erro) {
						JOptionPane.showMessageDialog(null, "Nenhuma porta encontrada!");
					}
					
				}
				catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "O valor da PORTA digitado não é um número!");
				}
				
				
				
				
				//catch {
					//JOptionPane.showMessageDialog(null, "Porta não encontrada!");
					//return;
				//}
			}
		});
		enviarDados.setBounds(145, 165, 141, 41);
		contentPane.add(enviarDados);
		
		JLabel labelNome = new JLabel("NOME:");
		labelNome.setFont(new Font("Verdana", Font.BOLD, 12));
		labelNome.setBounds(101, 64, 57, 14);
		contentPane.add(labelNome);
		
		JLabel labelPorta = new JLabel("PORTA:");
		labelPorta.setFont(new Font("Verdana", Font.BOLD, 12));
		labelPorta.setBounds(274, 64, 68, 14);
		contentPane.add(labelPorta);
	}
}
