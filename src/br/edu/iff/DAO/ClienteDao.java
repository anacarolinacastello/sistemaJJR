package br.edu.iff.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.conexao.ConexaoUtil;
import br.edu.iff.model.Cliente;



public class ClienteDao {
	
	public void inserir(Cliente cliente){
		
		try {
		
		Connection connection = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO cliente(nome, cpf, dataNascimento, telefone, rg, reputacao) VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getCpf());
		statement.setString(3, cliente.getDataNascimento());
		statement.setString(4, cliente.getTelefone());
		statement.setString(5, cliente.getRg());
		statement.setInt(6, cliente.getReputacao());
		
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
			
			String sql = "DELETE FROM cliente WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.setInt(1, id);
			
			statement.execute();
			statement.close();
			
			System.out.println("Removido com sucesso");

		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}
	
	public List<Cliente> listarTodos(){
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM cliente";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(resultset.getInt("id"));
				cliente.setNome(resultset.getString("nome"));
				cliente.setCpf(resultset.getString("cpf"));
				cliente.setDataNascimento(resultset.getString("dataNascimento"));
				cliente.setTelefone(resultset.getString("telefone"));
				cliente.setRg(resultset.getString("rg"));
				cliente.setReputacao(resultset.getInt("reputacao"));
	
				listaClientes.add(cliente);
				
			}
			connection.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return listaClientes;
		
	}
	public void atualizar(Cliente cliente){
		
		try {
		
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE cliente SET nome = ?, cpf = ?, dataNascimento = ?, telefone = ?, rg = ?, reputacao = ? WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
		
			
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getDataNascimento());
			statement.setString(4, cliente.getTelefone());
			statement.setString(5, cliente.getRg());
			statement.setInt(6, cliente.getReputacao());
			statement.setInt(7, cliente.getId());
			
			statement.execute();
			statement.close();
			
			System.out.println("Atualizado com sucesso");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}
	
	public static void main(String[] args) throws ParseException {
		
	/*	Cliente cliente = new Cliente();
		cliente.setNome("Ralph");
		cliente.setCpf("22925866989");

		cliente.setDataNascimento("63011993");
		
		cliente.setTelefone("22955677890");
		cliente.setRg("304567889");
		cliente.setReputacao(6);
		
	
		
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.inserir(cliente);*/
		
	
		ClienteDao clienteDao = new ClienteDao();
		
		List<Cliente> listaClientes = new ArrayList<>();
		
		listaClientes = clienteDao.listarTodos();
		for(int i = 0; i <listaClientes.size(); i++) {
			
			System.out.println(listaClientes.get(i));
		}
		
			
		
	}

}
