package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OperacoesNoBancoDeDados {
	
	//Atributo
	private Connection conexao;
	
	public OperacoesNoBancoDeDados() {
		
		// O nosso atributo vai receber uma nova conexão com o banco de dados		
		this.conexao = new ConectarAoBancoDeDados().getConnection();
	}
	
	public void cadastrar(DadosAgenda objeto) {
		
		try {
			//insert = Inserir
			//tabela_cadastro - tabela do banco de dados
			//values - valores
			String informacoesSql = "insert into tabela_cadastro(nome, telefone, email, endereco, nascimento, filhos)"
					+ "values(?,?,?,?,?,?)";
			
				//Preparando/Tratando a execução dos comando SQL
				PreparedStatement gravarInformacao = conexao.prepareStatement(informacoesSql);
				gravarInformacao.setString(1, objeto.getNome());
				gravarInformacao.setString(2, objeto.getTelefone());
				gravarInformacao.setString(3, objeto.getEmail());
				gravarInformacao.setString(4, objeto.getEndereco());
				gravarInformacao.setString(5, objeto.getNascimento());
				gravarInformacao.setString(6, objeto.getFilhos());
				
				//Executa os comandos SQL
				gravarInformacao.execute();
				
				//Fecha
				gravarInformacao.close();
				
				JOptionPane.showMessageDialog(null, "Dados Cadastrados com Sucesso!");
				
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!");

		}
		
	}

}
