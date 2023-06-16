/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author teclab
 */
public class Venda {
    
    private Integer id;
    private Date dataVenda;
    private Cliente cliente;
    private List<ItensVenda> itensVenda;

    public Venda() {
    }

    public Venda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
}
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}
