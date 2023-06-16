/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.ProdutoDAO;
import Model.Cliente;
import Model.ItensVenda;
import Model.Produto;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author clebe
 */
public class FrmRegistraVenda extends javax.swing.JInternalFrame {

   private DefaultTableModel tableModel;
    private List<ItensVenda> itensVenda;
    private Produto produto;
    private Cliente cliente;
    //List<Produto> lista;
    private int modo;
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        jTxtNomeProduto.setText(produto.getNome());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        jTxtNomeCliente.setText(cliente.getNome());
    }
    
      private void defineModelo() {
        tableModel = (DefaultTableModel) jTblItensVenda.getModel();
        try {
            DecimalFormat formatoValor = new DecimalFormat("#,###.00");
            NumberFormatter formatterValor = new NumberFormatter(formatoValor);
            formatterValor.setValueClass(Double.class);
            jTxtValorTotal.setFormatterFactory(new DefaultFormatterFactory(formatterValor));

            DecimalFormat formatoEstoque = new DecimalFormat("#,###");
            NumberFormatter formatterEstoque = new NumberFormatter(formatoEstoque);
            formatterEstoque.setValueClass(Integer.class);
            jTxtQuantidade.setFormatterFactory(new DefaultFormatterFactory(formatterEstoque));

            jTblItensVenda.getColumnModel().getColumn(0).setPreferredWidth(400);
        } catch (Exception ex) {
            Logger.getLogger(FrmRegistraVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void listar() {
        double valorTotal = 0.0;
        for (int i = 0; i < itensVenda.size(); i++) {
            tableModel.insertRow(i, new Object[]{itensVenda.get(i).getProduto().getNome(),
                itensVenda.get(i).getQtde(),
                itensVenda.get(i).getProduto().getValor(),
                itensVenda.get(i).getProduto().getValor() * itensVenda.get(i).getQtde()
            });
            valorTotal += itensVenda.get(i).getProduto().getValor() * itensVenda.get(i).getQtde();
        }
        jTxtValorTotal.setValue(valorTotal);
        
    }

          private void incluirProduto() {
        if (produto == null) {
            JOptionPane.showMessageDialog(this, "Selecionar o produto!", "Erro", JOptionPane.ERROR_MESSAGE);
            jBtnSelecionaProduto.requestFocus();
        } else if(jTxtQuantidade.getText() == null) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            ItensVenda item = new ItensVenda();
            item.setProduto(produto);
            item.setQtde((Integer) jTxtQuantidade.getValue());
            item.setValor(produto.getValor());

            itensVenda.add(item);
            listar();
        }
    }
         private void excluirProduto() {
        if (jTblItensVenda.getSelectedRow() != -1) {
            itensVenda.remove(jTblItensVenda.getSelectedRow());
            listar();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item da lista!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
         
         private void RegistraVenda() {
        if (getCliente() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (itensVenda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Insira itens na venda!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Venda venda = new Venda();
            venda.setCliente(getCliente());

            Calendar dataAtual = Calendar.getInstance();
            venda.setDataVenda(new java.sql.Date(dataAtual.getTime().getTime()));

            venda.setItensVenda(itensVenda);

            VendaDAO vendaBD = new VendaDAO();
            if (vendaBD.registrarVenda(venda)) {
                JOptionPane.showMessageDialog(this, "Venda registrada com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
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
        jTxtNomeCliente = new javax.swing.JTextField();
        jBtnSelecionarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblItensVenda = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTxtNomeProduto = new javax.swing.JTextField();
        jBtnSelecionaProduto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTxtQuantidade = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTxtValorTotal = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jBtnExcluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();

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
        jLabel1.setText("REGISTRA VENDA");
        jPanel1.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jTxtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jTxtNomeCliente, gridBagConstraints);

        jBtnSelecionarCliente.setMnemonic('p');
        jBtnSelecionarCliente.setText("...");
        jBtnSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelecionarClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jBtnSelecionarCliente, gridBagConstraints);

        jTblItensVenda.setModel(new javax.swing.table.DefaultTableModel(
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
        jTblItensVenda.getTableHeader().setReorderingAllowed(false);
        jTblItensVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblItensVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblItensVenda);
        if (jTblItensVenda.getColumnModel().getColumnCount() > 0) {
            jTblItensVenda.getColumnModel().getColumn(0).setMinWidth(1);
            jTblItensVenda.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        jLabel3.setText("Produto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jLabel3, gridBagConstraints);

        jTxtNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeProdutoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jTxtNomeProduto, gridBagConstraints);

        jBtnSelecionaProduto.setText("...");
        jBtnSelecionaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelecionaProdutoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jBtnSelecionaProduto, gridBagConstraints);

        jLabel4.setText("Qtde");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jLabel4, gridBagConstraints);

        jButton2.setText("Incluir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jButton2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jTxtQuantidade, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Valor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel6, gridBagConstraints);

        jTxtValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtValorTotalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jTxtValorTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtnExcluir.setText("Excluir Item");
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void jBtnSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelecionarClienteActionPerformed
        FrmProduto produtoFrame = new FrmProduto(this);
        produtoFrame.setVisible(true);
        this.getDesktopPane().add(produtoFrame);
        produtoFrame.toFront();
    
    }//GEN-LAST:event_jBtnSelecionarClienteActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        registarVenda();
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void jTblItensVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblItensVendaMouseClicked

    }//GEN-LAST:event_jTblItensVendaMouseClicked

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        excluirProduto();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jTxtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeClienteActionPerformed

    private void jTxtValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtValorTotalActionPerformed

    private void jTxtNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeProdutoActionPerformed

    private void jBtnSelecionaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelecionaProdutoActionPerformed
       
    public FrmProduto(FrmRegistraVenda registraVenda) {
        initComponents();
        listar();
        btnSelecionaProduto.setVisible(true);
        this.registraVenda = registraVenda;
    
    
    }//GEN-LAST:event_jBtnSelecionaProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JButton jBtnSelecionaProduto;
    private javax.swing.JButton jBtnSelecionarCliente;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTable jTblItensVenda;
    private javax.swing.JTextField jTxtNomeCliente;
    private javax.swing.JTextField jTxtNomeProduto;
    private javax.swing.JFormattedTextField jTxtQuantidade;
    private javax.swing.JFormattedTextField jTxtValorTotal;
    // End of variables declaration//GEN-END:variables
}
