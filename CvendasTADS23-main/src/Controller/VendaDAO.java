/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author teclab
 */
public class VendaDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSet rs2;
    private String registraVenda = "insert into venda (id_cliente, data_venda) values(?, ?)";
    private String registraItensVenda = "insert into itens_venda (id_produto, id_venda, qtde, valor) values(?, ?, ?, ?)";
    private String consultaUltimoId = "select LAST_INSERT_ID() as id from venda";
    private String consultaVendaPeriodo = "select v.*, c.* from venda v join cliente c on v.id_cliente = c.id where v.data_venda between ? and ?";
    private String consultaItensVenda = "select i.*, p.* from itens_venda i join produto p on i.id_produto = p.id where i.id_venda = ?";

    public boolean registrarVenda(Venda venda) {
        try {
            Conexao.conectar();
            ps = Conexao.conectar().prepareStatement(registraVenda);
            ps.setInt(1, venda.getCliente().getId());
            ps.setDate(2, venda.getDataVenda());

            ps.executeUpdate();

            ps = Conexao.conectar().prepareStatement(consultaUltimoId);
            rs = ps.executeQuery();
            rs.first();
            venda.setId(rs.getInt("id"));

            for (int i = 0; i < venda.getItensVenda().size(); i++) {
                ps = Conexao.conectar().prepareStatement(registraItensVenda);
                ps.setInt(1, venda.getItensVenda().get(i).getProduto().getId());
                ps.setInt(2, venda.getId());
                ps.setInt(3, venda.getItensVenda().get(i).getQtde());
                ps.setDouble(4, venda.getItensVenda().get(i).getValor());

                ps.executeUpdate();
            }

            Conexao.desconectar(Conexao.conectar());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
