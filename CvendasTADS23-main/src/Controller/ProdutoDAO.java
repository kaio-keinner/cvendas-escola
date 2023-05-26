/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clebe
 */
public class ProdutoDAO {
    private PreparedStatement pst;
    private ResultSet rs;
    private String consultarProduto = "select * from produto";
    private String consultarProdutoNome = "select * from produto where produto.nome like ?";
    private String incluirProduto = "insert into produto (nome, endereco, bairro, cidade, uf, cep, telefone, email)values (?,?,?,?,?,?,?,?)";
    private String alterarProduto = "update produto set nome = ?, endereco = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, telefone = ?, email = ? where produto.id = ?";
    
    private String excluirProduto = "delete from produto where produto.id = ?";
    
    public List<Produto> consultarProduto(){
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Produto produto;
        
        try {
            Conexao.conectar();
            pst = Conexao.conectar().prepareStatement(consultarProduto);
            rs = pst.executeQuery();
            
            while(rs.next()){
                produto = new Produto();
                //setando atributos
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
               
                //adicionando na lista
                listaProdutos.add(produto);
             }
            Conexao.desconectar(Conexao.conectar());
         } catch (Exception e) {
             e.printStackTrace();
        }
        return listaProdutos;
    }
    
    public List<Produto> consultaProdutoNome(String nome){
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Produto produto;
        try {
            Conexao.conectar();
            pst = Conexao.conectar().prepareStatement(consultarProdutoNome);
            //nome = "%"+nome +"%";
            pst.setString(1, nome);
            rs = pst.executeQuery();
            
            while(rs.next()){
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
               
                
                listaProdutos.add(produto);
            }
            Conexao.desconectar(Conexao.conectar());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProdutos;
    }
    
    public boolean icluirProduto(Produto produto){
        try {
            Conexao.conectar();
            pst = Conexao.conectar().prepareStatement(incluirProduto);
            pst.setString(1, produto.getNome());
            
            
            pst.executeUpdate();
            
            Conexao.desconectar(Conexao.conectar());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean alterarProduto(Produto produto){
        try {
            Conexao.conectar();
            pst = Conexao.conectar().prepareStatement(alterarProduto);
            pst.setString(1, produto.getNome());
            
            
            pst.setInt(9, produto.getId());
            
            pst.executeUpdate();
            
            Conexao.desconectar(Conexao.conectar());
          } catch (Exception e) {
              e.printStackTrace();
        }
        
        return true;
    }
    
    public boolean excluirProduto(Produto produto){
        try {
            Conexao.conectar();
            pst = Conexao.conectar().prepareStatement(excluirProduto);
            
            pst.setInt(1,produto.getId());
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
