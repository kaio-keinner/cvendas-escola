/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Model.Fornecedor;
import Controller.ProdutoDAO;
import Model.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Constantes;

/**
 *
 * @author clebe
 */
public class FrmProdutos extends javax.swing.JInternalFrame {
    
    private Fornecedor fornecedor;
    private int modo;
    List<Produto> lista;
    
    public FrmProdutos() {
        initComponents();
    }
    
     public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        TxtNomeFornecedor.setText(fornecedor.getNome());
    }

    public void listar() {
        ProdutoDAO produtoDao = new ProdutoDAO();
        lista = produtoDao.consultarProduto();
        DefaultTableModel dados = (DefaultTableModel) jTblProdutos.getModel();
        dados.setNumRows(0);

        for (Produto produto : lista) {
            dados.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
            });
        }

    }
    
    private void habilitarCampos(){
        jTxtNome.setEnabled(true);
        TxtNomeFornecedor.setEnabled(true);
        ftfEstoque.setEnabled(true);
        ftfValor.setEnabled(true);
    
    }
    
    private void desabilitarCampos(){
        jTxtNome.setEnabled(false);
        TxtNomeFornecedor.setEnabled(false);
        ftfEstoque.setEnabled(false);
        ftfValor.setEnabled(false);
       
    }
    
    private void desabilitarBotoes(){
        jBtnSalvar.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        jBtnNovo.setEnabled(true);
        jBtnAlterar.setEnabled(true);
        jBtnExcluir.setEnabled(true);
    }
    private void habilitarBotoes(){
        jBtnSalvar.setEnabled(true);
        jBtnCancelar.setEnabled(true);
        jBtnNovo.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
    }
    
    public void incluiProduto(){
        if(jTxtNome.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Informe o nome do Produto","Erro",JOptionPane.ERROR_MESSAGE);
            jTxtNome.requestFocus();
        }else{
            Produto produto = new Produto();
            produto.setNome(jTxtNome.getText().trim());
            produto.setFornecedor(getFornecedor());
            produto.setQtdestoque((Integer) ftfEstoque.getValue());
            produto.setValor((Integer) ftfValor.getValue());
            
           
            
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if(produtoDAO.icluirProduto(produto)){
                JOptionPane.showMessageDialog(this, "Produto Cadastrado com Sucesso!!!","Confirmação", JOptionPane.INFORMATION_MESSAGE);
                listar();
                desabilitarBotoes();
                desabilitarCampos();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar o Produto!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alteraProduto(){
        if(jTxtNome.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Imforme o nome do Produto","Erro",JOptionPane.ERROR_MESSAGE);
            jTxtNome.requestFocus();
        }else{
            Produto produto = new Produto();
            
            produto.setId(lista.get(jTblProdutos.getSelectedRow()).getId());
            produto.setNome(jTxtNome.getText().trim());
            produto.setFornecedor(getFornecedor());
            produto.setQtdestoque((Integer) ftfEstoque.getValue());
            produto.setValor((Integer) ftfValor.getValue());           
            
            ProdutoDAO produtoDao = new ProdutoDAO();
            if(produtoDao.alterarProduto(produto)){
                JOptionPane.showMessageDialog(this, "Produto alterado com Sucesso!!!","Confirmação", JOptionPane.INFORMATION_MESSAGE);
                listar();
                desabilitarBotoes();
                desabilitarCampos();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao alterar o Produto!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    private void excluiProduto() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        if (produtoDAO.excluirProduto(lista.get(jTblProdutos.getSelectedRow()))) {
            JOptionPane.showMessageDialog(this, "Dados do produto excluídos com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            listar();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtFiltroNome = new javax.swing.JTextField();
        jBtnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblProdutos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtNomeFornecedor = new javax.swing.JTextField();
        Bairro = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        ftfEstoque = new javax.swing.JFormattedTextField();
        ftfValor = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Java GUI Swing - TADS 2023 ! ! !");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Produtos");
        jPanel1.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Filtro por Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jTxtFiltroNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFiltroNomeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jTxtFiltroNome, gridBagConstraints);

        jBtnPesquisar.setMnemonic('p');
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jBtnPesquisar, gridBagConstraints);

        jTblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblProdutos.getTableHeader().setReorderingAllowed(false);
        jTblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblProdutos);
        if (jTblProdutos.getColumnModel().getColumnCount() > 0) {
            jTblProdutos.getColumnModel().getColumn(0).setMinWidth(1);
            jTblProdutos.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel3, gridBagConstraints);

        jTxtNome.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jTxtNome, gridBagConstraints);

        jLabel4.setText("Fornecedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel4, gridBagConstraints);

        TxtNomeFornecedor.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(TxtNomeFornecedor, gridBagConstraints);

        Bairro.setText("Estoque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(Bairro, gridBagConstraints);

        jLabel6.setText("Valor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel6, gridBagConstraints);

        jToggleButton1.setText("..");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jToggleButton1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(ftfEstoque, gridBagConstraints);

        ftfValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfValorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(ftfValor, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton1.setText("Selecionar Produto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnNovo);

        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnAlterar);

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnExcluir);

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.setEnabled(false);
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnSalvar);

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.setEnabled(false);
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnCancelar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        
    }//GEN-LAST:event_formInternalFrameActivated

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        String nome = "%"+jTxtFiltroNome.getText()+"%";
        ProdutoDAO produtoDao = new ProdutoDAO();
        List<Produto> lista = produtoDao.consultaProdutoNome(nome);
        DefaultTableModel dados = (DefaultTableModel) jTblProdutos.getModel();
        dados.setRowCount(0);
        for (Produto produto : lista) {
            dados.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
            });
        }
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        habilitarCampos();
        habilitarBotoes();
        modo = Constantes.INSERT_MODE;
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        if(modo == Constantes.INSERT_MODE){
            incluiProduto();
        }else if(modo == Constantes.EDIT_MODE){
            alteraProduto();
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        listar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jTblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblProdutosMouseClicked
        if(jTblProdutos.getSelectedRow()!=-1){
           int indice = jTblProdutos.getSelectedRow();
           jTxtNome.setText(lista.get(indice).getNome());
           
        }
    }//GEN-LAST:event_jTblProdutosMouseClicked

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        if(jTblProdutos.getSelectedRow()!=-1){
            habilitarBotoes();
            habilitarCampos();
            modo = Constantes.EDIT_MODE;
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um produto da lista","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if(jTblProdutos.getSelectedRow()!=-1){
            int resposta = JOptionPane.showConfirmDialog(this, "Confirmar exclusão de produto?","Confirmação",JOptionPane.YES_NO_OPTION);
            if(resposta == JOptionPane.YES_OPTION){
                excluiProduto();
        }else{
                JOptionPane.showMessageDialog(this, "Selecione um produto da lista");
            }
    }//GEN-LAST:event_jBtnExcluirActionPerformed
    }
    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        habilitarBotoes();
        habilitarCampos();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTxtFiltroNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFiltroNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFiltroNomeActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ftfValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfValorActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bairro;
    private javax.swing.JTextField TxtNomeFornecedor;
    private javax.swing.JFormattedTextField ftfEstoque;
    private javax.swing.JFormattedTextField ftfValor;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblProdutos;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jTxtFiltroNome;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
