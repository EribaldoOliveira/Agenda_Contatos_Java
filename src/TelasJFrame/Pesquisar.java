package TelasJFrame;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.DadosAgenda;
import Classes.OperacoesNoBancoDeDados;

public class Pesquisar extends JFrame {

	private JPanel contentPane;
	private JTextField txtConsulta;
	private JTextField txtQuantidadeItens;
	private JScrollPane scrollPane;
	private JTable tabelaAgenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisar frame = new Pesquisar();
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
	public Pesquisar() {
		setTitle("Pesquisar Dados");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		
		//Point representa o local no espaço de coordenadas x e y
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		int largura = 800;
		int altura = 500;
		
		//centraliza no meio da tela
		setBounds(centro.x - largura / 2, centro.y - altura / 2, 718, 485 );
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(573, 59, 119, 30);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro abreTela = new Cadastro();
				abreTela.setVisible(true);
				
			}
		});
		contentPane.setLayout(null);
		btnNovo.setIcon(new ImageIcon(Pesquisar.class.getResource("/Imagens/adicionar-ficheiro.png")));
		btnNovo.setMnemonic('N');
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNovo);
		
		JLabel lblNewLabel = new JLabel("Digite algo para pesquisar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 242, 30);
		contentPane.add(lblNewLabel);
		
		txtConsulta = new JTextField();
		txtConsulta.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtConsulta.setBounds(10, 42, 429, 30);
		contentPane.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		txtQuantidadeItens = new JTextField();
		txtQuantidadeItens.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtQuantidadeItens.setBounds(10, 77, 334, 30);
		contentPane.add(txtQuantidadeItens);
		txtQuantidadeItens.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 551, 271);
		contentPane.add(scrollPane);
		
		tabelaAgenda = new JTable();
		scrollPane.setViewportView(tabelaAgenda);
		tabelaAgenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Telefone", "Email", "Endere\u00E7o", "Nascimento", "Sexo"
			}
		));
		
		carregarItens();
		 
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	}
	
	//método para carregar as informações
	public void carregarItens() {
		
		// instanciando para ter acesso à todos os ítens; ou seja, ter acesso à classe
		 OperacoesNoBancoDeDados Itens = new OperacoesNoBancoDeDados();
		 List<DadosAgenda> itensLista = itens.listarItens(); 	
		 
		 //Criando um objeto que vai passar os dados da lista para a tabela
		 DafaultTableModel dados = (tabelaTableModel) tabelaAgenda.getModel();
		 
		 //Limpar os dadosda tabela
		 dados.setNumRows(0);
		
		 for (DadosAgenda linha: itensLista) {
			 
			 dados.addRow(new Object[]){
				 
				 Linha.getId(),
				 Linha.getNome(),
				 Linha.getTelefone(),
				 Linha.getEmail(),
				 Linha.getEndereco(),
				 Linha.getNascimento(),
				 Linha.getFilho()
				  
				 
			 });
			 
			 
		 }
		 
 		
	}
	
}
