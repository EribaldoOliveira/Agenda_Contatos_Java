package TelaPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Classes.ConectarAoBancoDeDados;
import TelasJFrame.Pesquisar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;



public class Principal {

	private JFrame frmAgendaDeContatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmAgendaDeContatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaDeContatos = new JFrame();
		frmAgendaDeContatos.setTitle("Agenda de Contatos");
		
		//Maximiza a tela
		frmAgendaDeContatos.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frmAgendaDeContatos.getContentPane().setLayout(null);
		
		JButton btnTestarConexãoBD = new JButton("Testar Conexão com BD");
		btnTestarConexãoBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ConectarAoBancoDeDados().getConnection();
				JOptionPane.showMessageDialog(null, "Banco de Dados conectado com sucesso!");
				
			}
		});
		btnTestarConexãoBD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTestarConexãoBD.setBounds(210, 125, 276, 48);
		frmAgendaDeContatos.getContentPane().add(btnTestarConexãoBD);
		
		JMenuBar menuBar = new JMenuBar();
		frmAgendaDeContatos.setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/arquivo.png")));
		menuBar.add(menuArquivo);
		
		JMenuItem subMenuContatos = new JMenuItem("Contatos");
		subMenuContatos.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/lupa.png")));
		subMenuContatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instanciando para ter acesso a tela
				Pesquisar telaPesquisar = new Pesquisar();		
				
				//Deixando a tela de pesquisa visível
				telaPesquisar.setVisible(true);
			}
		});
		menuArquivo.add(subMenuContatos);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/central-de-ajuda(2).png")));
		menuBar.add(menuAjuda);
		
		JMenuItem subMenuSair = new JMenuItem("Sair");
		subMenuSair.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/sair.png")));
		subMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Fecho o formulário
				//Fecho o sistema
				frmAgendaDeContatos.dispose();
				
			}
		});
		menuAjuda.add(subMenuSair);
	}
}
