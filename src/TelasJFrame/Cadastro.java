package TelasJFrame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Classes.DadosAgenda;
import Classes.OperacoesNoBancoDeDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	
	public static MaskFormatter txtTelefone;
	public static MaskFormatter txtNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("Cadastrar Dados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		
		//Point representa o local no espaço de coordenadas x e y
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		int largura = 800;
		int altura = 500;
		
		//centraliza no meio da tela
		setBounds(centro.x - largura / 2, centro.y - altura / 2, 800, 500 );
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 11, 221, 30);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setBounds(20, 47, 98, 30);
		txtId.setEnabled(false);
		txtId.setEditable(false);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(20, 88, 221, 30);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNome.setColumns(10);
		txtNome.setBounds(20, 124, 731, 30);
		contentPane.add(txtNome);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(20, 242, 221, 30);
		contentPane.add(lblTelefone);
		
		JFormattedTextField txtTelefone = new JFormattedTextField( arrumaMascaraTelefone() );
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTelefone.setBounds(20, 276, 235, 30);
		contentPane.add(txtTelefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(302, 240, 221, 30);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(302, 276, 449, 30);
		contentPane.add(txtEmail);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEndereco.setBounds(20, 317, 221, 30);
		contentPane.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(20, 353, 731, 30);
		contentPane.add(txtEndereco);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNascimento.setBounds(20, 165, 221, 30);
		contentPane.add(lblNascimento);
		
		JFormattedTextField txtNascimento = new JFormattedTextField( arrumaMascaraNascimento() );
		txtNascimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNascimento.setBounds(20, 199, 235, 30);
		contentPane.add(txtNascimento);
		
		JLabel lblFilhos = new JLabel("Filhos");
		lblFilhos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFilhos.setBounds(302, 165, 221, 30);
		contentPane.add(lblFilhos);
		
		JComboBox comboBox_Filhos = new JComboBox();
		comboBox_Filhos.setModel(new DefaultComboBoxModel(new String[] {"-", "Sim", "Não"}));
		comboBox_Filhos.setBounds(302, 199, 98, 30);
		contentPane.add(comboBox_Filhos);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			private JLabel txtNascimento;
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Instanciando a classe DadosAgenda
					DadosAgenda objeto = new DadosAgenda();
					objeto.setNome(txtNome.getText());
					objeto.setTelefone(txtTelefone.getText());
					objeto.setEmail(txtEmail.getText());
					objeto.setEndereco(txtEndereco.getText());
					objeto.setNascimento(txtNascimento.getText());
					objeto.setFilhos(comboBox_Filhos.getSelectedItem().toString());
					
					//Instanciando a classe OperacoesNoBancoDeDados para usar os métodos dela
					OperacoesNoBancoDeDados SalvarDados = new OperacoesNoBancoDeDados();
					SalvarDados.cadastrar(objeto);
					
					//fecha o formulário após salvar os dados
					dispose();
					
				}catch (Exception trata) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!" + trata);
					
				}
				
								
			}
		});
		btnSalvar.setMnemonic('S');
		btnSalvar.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/disquete_24px.png")));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setBounds(632, 24, 119, 30);
		contentPane.add(btnSalvar);
	}
	
	public static MaskFormatter arrumaMascaraTelefone() {
					
			try {
				txtTelefone = new MaskFormatter("(##) #####-####");
			} catch (ParseException e) {		
				e.printStackTrace();
			}
			
			//Substitui os # por _
			txtTelefone.setPlaceholderCharacter('_');
		return txtTelefone;
		
	}
	
	public static MaskFormatter arrumaMascaraNascimento() {
		
		try {
			txtNascimento = new MaskFormatter("##/##/####");
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		
		//Substitui os # por _
		txtNascimento.setPlaceholderCharacter('_');
	return txtNascimento;
	
}
	
}
