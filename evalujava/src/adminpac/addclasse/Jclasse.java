/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpac.addclasse;

import connexion.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MBS
 */
public class Jclasse extends javax.swing.JFrame {

   
    public Jclasse() {
        initComponents();
        Remplitable();
    }
public  void Remplitable(){
    String grad_nom="",filnom="";
    try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();
      
        String chsql="select *  from classroom ";
        ResultSet res= stmt.executeQuery(chsql);
        DefaultTableModel d=(DefaultTableModel) tbclas.getModel();
        while(d.getRowCount()>0){
                 d.removeRow(0);
            
        }

         while(res.next()){
            String nom =res.getString("clas_nom");
            String ann =res.getString("clas_ann");
            int fil =res.getInt("fil_id");
            int grad =res.getInt("grad_id");
            
                 try{
        Connexion cok =new Connexion();
        Statement stmtk=cok.con.createStatement();

        String chsqlk=" select * from filiere where fil_id ="+fil+"";
        ResultSet resk= stmtk.executeQuery(chsqlk);

         if(resk.next()){
            filnom= resk.getString("fil_nom");
         }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
           try{
        Connexion cokh =new Connexion();
        Statement stmtkh=cokh.con.createStatement();

        String chsqlkh=" select * from grade where grad_id ="+grad+"";
        ResultSet reskh= stmtkh.executeQuery(chsqlkh);

         if(reskh.next()){
            grad_nom= reskh.getString("grad_nom");
          
            
         }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
            

            

            String tbData[]={nom,ann,filnom,grad_nom};
            DefaultTableModel tbmodel=(DefaultTableModel) tbclas.getModel();
            tbmodel.addRow(tbData);
            }

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
} 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbclas = new javax.swing.JTable();
        btnaj = new javax.swing.JButton();
        btnmod = new javax.swing.JButton();
        btncon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Classes");

        tbclas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "classe nom", "class_ann", "filiere", "grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbclas);
        if (tbclas.getColumnModel().getColumnCount() > 0) {
            tbclas.getColumnModel().getColumn(0).setResizable(false);
            tbclas.getColumnModel().getColumn(1).setResizable(false);
            tbclas.getColumnModel().getColumn(2).setResizable(false);
            tbclas.getColumnModel().getColumn(3).setResizable(false);
        }

        btnaj.setText("Ajouter");
        btnaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajActionPerformed(evt);
            }
        });

        btnmod.setText("modifier");
        btnmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodActionPerformed(evt);
            }
        });

        btncon.setText("Consulter");
        btncon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnaj)
                .addGap(181, 181, 181)
                .addComponent(btnmod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncon)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaj)
                    .addComponent(btnmod)
                    .addComponent(btncon))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajActionPerformed
        Ajouterclasse ac=new Ajouterclasse();
        ac.setVisible(true);
 
    }//GEN-LAST:event_btnajActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
      //Remplitable();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodActionPerformed
  int row =tbclas.getSelectedRow();
         if(row>=0){
                     String cell= tbclas.getModel().getValueAt(row, 0).toString();
             Modclasse me=new Modclasse();
             me.setVisible(true);
         try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

        String chsql=" select *  from classroom"
                + " where clas_nom like '"+cell+"'";
        ResultSet res= stmt.executeQuery(chsql);

         if(res.next()){
            me.txtnom1.setText(res.getString("clas_nom"));
            me.txtann1.setText(res.getString("clas_ann"));
            me.idclas=Integer.parseInt(res.getString("clas_id"));
             try{
        Connexion cod =new Connexion();
        Statement stmtd=cod.con.createStatement();

        String chsqld=" SELECT * FROM filiere JOIN classroom ON (filiere.fil_id = classroom.fil_id) " +
" where classroom.clas_id="+res.getString("clas_id");
        ResultSet resd= stmtd.executeQuery(chsqld);

         if(resd.next()){
            me.cbfil1.setSelectedItem(resd.getString("fil_nom"));
         }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    } try{
        Connexion cod =new Connexion();
        Statement stmtd=cod.con.createStatement();

        String chsqld=" SELECT * FROM grade JOIN classroom ON (grade.grad_id = classroom.grad_id) " +
" where classroom.clas_id="+res.getString("clas_id");
        ResultSet resd= stmtd.executeQuery(chsqld);

         if(resd.next()){
            me.cbgrad1.setSelectedItem(resd.getString("grad_nom"));
         }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
         
         }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
        }else{
         JOptionPane.showMessageDialog(this,"veillez selectionner un etudiant");}    }//GEN-LAST:event_btnmodActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
//Remplitable();
    }//GEN-LAST:event_formFocusGained

    private void btnconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconActionPerformed
       int row =tbclas.getSelectedRow();
         if(row>=0){
                     String cell= tbclas.getModel().getValueAt(row, 0).toString();
             Conclasse me=new Conclasse();
             me.setVisible(true);
         try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

        String chsql=" select *  from classroom"
                + " where clas_nom like '"+cell+"'";
        ResultSet res= stmt.executeQuery(chsql);

         if(res.next()){
            me.txtnom1.setText(res.getString("clas_nom"));
            me.txtann1.setText(res.getString("clas_ann"));
             try{
        Connexion cod =new Connexion();
        Statement stmtd=cod.con.createStatement();

        String chsqld=" SELECT * FROM filiere JOIN classroom ON (filiere.fil_id = classroom.fil_id) " +
" where classroom.clas_id="+res.getString("clas_id");
        ResultSet resd= stmtd.executeQuery(chsqld);

         if(resd.next()){
            me.cbfil1.setSelectedItem(resd.getString("fil_nom"));
         }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    } try{
        Connexion cod =new Connexion();
        Statement stmtd=cod.con.createStatement();

        String chsqld=" SELECT * FROM grade JOIN classroom ON (grade.grad_id = classroom.grad_id) " +
" where classroom.clas_id="+res.getString("clas_id");
        ResultSet resd= stmtd.executeQuery(chsqld);

         if(resd.next()){
            me.cbgrad1.setSelectedItem(resd.getString("grad_nom"));
         }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
         
         }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
        }else{
         JOptionPane.showMessageDialog(this,"veillez selectionner un etudiant");}
    }//GEN-LAST:event_btnconActionPerformed

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
            java.util.logging.Logger.getLogger(Jclasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jclasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jclasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jclasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jclasse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaj;
    private javax.swing.JButton btncon;
    private javax.swing.JButton btnmod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbclas;
    // End of variables declaration//GEN-END:variables
}
