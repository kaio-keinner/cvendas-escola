/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



/**
 *
 * @author clebe
 */

public class Produto  {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private Integer valor;
    private Integer qtdestoque;
    private Fornecedor fornecedor;

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

   

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(Integer qtdestoque) {
        this.qtdestoque = qtdestoque;
    }

    
    
    
}
