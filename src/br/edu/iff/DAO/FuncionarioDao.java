package br.edu.iff.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.conexao.ConexaoUtil;
import br.edu.iff.model.Funcionario;



public class FuncionarioDao {
	
	public void inserir(Funcionario funcionario){
		
		try {
		
		Connection connection = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO funcionario(nome, cpf, dataNascimento, telefone, usuario, chave) VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, funcionario.getNome());
		statement.setString(2, funcionario.getCpf());
		statement.setString(3, funcionario.getDataNascimento());
		statement.setString(4, funcionario.getTelefone());
		statement.setString(5, funcionario.getUsuario());
		statement.setInt(6, funcionario.getChave());
		
		statement.execute();
		connection.close();
		
		System.out.println("Cadastrado com sucesso");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}
	
	public void remover(int id){
		
		try {
		
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM funcionario WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.setInt(1, id);
			
			statement.execute();
			statement.close();
			
			System.out.println("Funcionário removido com sucesso");

		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}
	
	public List<Funcionario> listarTodos(){
		
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM funcionario";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				
				Funcionario funcionario = new Funcionario();
				funcionario.setId(resultset.getInt("id"));
				funcionario.setNome(resultset.getString("nome"));
				funcionario.setCpf(resultset.getString("cpf"));
				funcionario.setDataNascimento(resultset.getString("dataNascimento"));
				funcionario.setTelefone(resultset.getString("telefone"));
				funcionario.setUsuario(resultset.getString("usuario"));
				funcionario.setChave(resultset.getInt("chave"));
	
				listaFuncionarios.add(funcionario);
				
			}
			connection.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return listaFuncionarios;
		
	}
	public void atualizar(Funcionario funcionario){
		
		try {
		
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE funcionario SET nome = ?, cpf = ?, dataNascimento = ?, telefone = ?, usuario = ?, chave = ? WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
		
			
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCpf());
			statement.setString(3, funcionario.getDataNascimento());
			statement.setString(4, funcionario.getTelefone());
			statement.setString(5, funcionario.getUsuario());
			statement.setInt(6, funcionario.getChave());
			statement.setInt(7, funcionario.getId());
			
			statement.execute();
			statement.close();
			
			System.out.println("Funcionário atualizado com sucesso");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}
	
	public static void main(String[] args) throws ParseException {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Carol");
		funcionario.setCpf("22925886989");

		funcionario.setDataNascimento("14011999");
		
		funcionario.setTelefone("22995577899");
		funcionario.setUsuario("carol");
		funcionario.setChave(282633);
		
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.inserir(funcionario);
		

			
		
	}

}
