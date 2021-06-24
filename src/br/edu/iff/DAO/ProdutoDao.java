package br.edu.iff.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.conexao.ConexaoUtil;
import br.edu.iff.model.Produto;



public class ProdutoDao {
	
	public void inserir(Produto produto){
		
		try {
		
		Connection connection = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO produto(numeroPeca, tipo, modelo, material, preco, quantidade) VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, produto.getNumeroPeca());
		statement.setString(2, produto.getTipo());
		statement.setString(3, produto.getModelo());
		statement.setString(4, produto.getMaterial());
		statement.setFloat(5, produto.getPreco());
		statement.setInt(6, produto.getQuantidade());
		
		statement.execute();
		connection.close();
		
		System.out.println("Produto cadastrado com sucesso");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}
	
	public void remover(int id){
		
		try {
		
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM produto WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.setInt(1, id);
			
			statement.execute();
			statement.close();
			
			System.out.println("Produto removido com sucesso");

		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}
	
	public List<Produto> listarTodos(){
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM produto";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				
				Produto produto = new Produto();
				
				produto.setId(resultset.getInt("id"));
				produto.setNumeroPeca(resultset.getInt("numeroPeca"));
				produto.setTipo(resultset.getString("tipo"));
				produto.setModelo(resultset.getString("modelo"));
				produto.setMaterial(resultset.getString("material"));
				produto.setPreco(resultset.getFloat("preco"));
				produto.setQuantidade(resultset.getInt("quantidade"));
	
				listaProdutos.add(produto);
				
			}
			connection.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return listaProdutos;
		
	}
	public void atualizar(Produto produto){
		
		try {
		
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE produto SET numeroPeca = ?, tipo = ?, modelo = ?, material = ?, preco = ?, quantidade = ? WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
		
			
			statement.setInt(1, produto.getNumeroPeca());
			statement.setString(2, produto.getTipo());
			statement.setString(3, produto.getModelo());
			statement.setString(4, produto.getMaterial());
			statement.setFloat(5, produto.getPreco());
			statement.setInt(6, produto.getQuantidade());
			statement.setInt(7, produto.getId());
			
			statement.execute();
			statement.close();
			
			System.out.println("Produto atualizado com sucesso");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
	}
	
	public static void main(String[] args) {
		
		Produto produto = new Produto();
		
		produto.setNumeroPeca(0226);
		produto.setTipo("colar");
		produto.setModelo("Ouro 18k");
		produto.setMaterial("ouro");
		produto.setPreco(600);
		produto.setQuantidade(6);
		
		
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.inserir(produto);
		
	
		}
		
}
	