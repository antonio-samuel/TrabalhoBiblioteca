/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.visao;

import br.com.controle.AutorDAO;
import br.com.controle.CategoriaDAO;
import br.com.controle.LivroDAO;
import br.com.modelo.Autor;
import br.com.modelo.Categoria;
import br.com.modelo.Livro;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class AlterarLivro extends javax.swing.JFrame {

    /**
     * Creates new form AlterarLivro
     */
    public AlterarLivro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTIdLivro = new javax.swing.JTextField();
        jTnomel = new javax.swing.JTextField();
        jTpreco = new javax.swing.JTextField();
        jTSinopse = new javax.swing.JTextField();
        jBpesquisar = new javax.swing.JButton();
        jBalterar = new javax.swing.JButton();
        jTnomea = new javax.swing.JTextField();
        jTcategoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id do livro:");

        jLabel2.setText("Nome do Autor:");

        jLabel3.setText("Nome do Livro:");

        jLabel4.setText("Preço:");

        jLabel5.setText("Sinopse:");

        jLabel6.setText("Categoria: ");

        jTIdLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdLivroActionPerformed(evt);
            }
        });

        jBpesquisar.setText("Pesquisar");
        jBpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpesquisarActionPerformed(evt);
            }
        });

        jBalterar.setText("Alterar");
        jBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jBpesquisar)
                        .addGap(83, 83, 83)
                        .addComponent(jBalterar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTnomel)
                            .addComponent(jTpreco)
                            .addComponent(jTSinopse)
                            .addComponent(jTIdLivro)
                            .addComponent(jTnomea)
                            .addComponent(jTcategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTnomea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTnomel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBalterar)
                    .addComponent(jBpesquisar))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpesquisarActionPerformed
     try {
        int id = Integer.parseInt(jTIdLivro.getText());

        Livro livro = new Livro();
        livro.setId(id); // define o ID no objeto

        LivroDAO dao = new LivroDAO();
        dao.pesquisarPorId(livro); // preenche o livro

        if (livro.getTitulo() != null) {
            jTnomel.setText(livro.getTitulo());
            jTSinopse.setText(livro.getSinopse());
            jTpreco.setText(String.valueOf(livro.getValor()));

            // Preenche combo box ou campos com nome da categoria/autor
            jTcategoria.setText(livro.getNomeCategoria());
            jTnomea.setText(livro.getNomeAutor());

            // Ou, se forem JTextField:
            // jTcategoria.setText(livro.getNomeCategoria());
            // jTnomea.setText(livro.getNomeAutor());
        } else {
            JOptionPane.showMessageDialog(null, "Livro não encontrado!");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao pesquisar livro: " + e.getMessage());
    }

    }//GEN-LAST:event_jBpesquisarActionPerformed

    private void jBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalterarActionPerformed
          try {
        int id = Integer.parseInt(jTIdLivro.getText());
        String titulo = jTnomel.getText();
        String sinopse = jTSinopse.getText();
        double valor = Double.parseDouble(jTpreco.getText());

        String nomeCategoria = jTcategoria.getText().trim();
        String nomeAutor = jTnomea.getText().trim();

        LivroDAO livroDAO = new LivroDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        AutorDAO autDAO = new AutorDAO();

        // Busca os dados antigos do livro para manter os IDs
        Livro livro = new Livro();
        livro.setId(id);
        livroDAO.pesquisarPorId(livro); // método preenche os dados dentro do objeto

        if (livro == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            return;
        }

        // Atualiza nomes de autor e categoria diretamente
        catDAO.atualizarNome(livro.getIdCategoria(), nomeCategoria);
        autDAO.atualizarNome(livro.getIdAutor(), nomeAutor);

        // Atualiza o restante dos dados do livro
        Livro novoLivro = new Livro();
        novoLivro.setId(id);
        novoLivro.setTitulo(titulo);
        novoLivro.setSinopse(sinopse);
        novoLivro.setValor(valor);
        novoLivro.setIdCategoria(livro.getIdCategoria());
        novoLivro.setIdAutor(livro.getIdAutor());

        livroDAO.editar(novoLivro);
        JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao alterar livro: " + e.getMessage());
    }
    }//GEN-LAST:event_jBalterarActionPerformed

    private void jTIdLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIdLivroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlterarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarLivro().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBalterar;
    private javax.swing.JButton jBpesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTIdLivro;
    private javax.swing.JTextField jTSinopse;
    private javax.swing.JTextField jTcategoria;
    private javax.swing.JTextField jTnomea;
    private javax.swing.JTextField jTnomel;
    private javax.swing.JTextField jTpreco;
    // End of variables declaration//GEN-END:variables
}
