/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpac.addprof;

import adminpac.adetudiant.*;
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
public class Allprof extends javax.swing.JFrame {

    
    public Allprof() {
        initComponents();

          remmat();
        Remplitable();
       remclasse();

    }
    
     public void remmat(){
            String commat="select mat_nom from matiere";
          Connexion.RempCombos(cbmat,commat,"mat_nom");

    }
     public void remclasse(){

            String comcla="select clas_nom from classroom ";
          Connexion.RempCombos(cbclasse,comcla,"clas_nom");

    }
public  void Remplitable(){
    try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();
      
        String chsql="select *  from professeur ";
        ResultSet res= stmt.executeQuery(chsql);
        DefaultTableModel d=(DefaultTableModel) tbprof.getModel();
        while(d.getRowCount()>0){
                 d.removeRow(0);
            
        }

         while(res.next()){
            String nom =res.getString("prof_nom");
            String prenom =res.getString("prof_prenom");
            String email =res.getString("prof_email");
            String password =res.getString("prof_password");
            String tel =res.getString("prof_tel");

            String tbData[]={nom,prenom,email,password,tel};
            DefaultTableModel tbmodel=(DefaultTableModel) tbprof.getModel();
            tbmodel.addRow(tbData);
            }

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
} 
public void rembtn(){
    if(checkmat.isSelected() && checkclas.isSelected()){
        
          try{
            Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

String chmat="select mat_id from matiere where mat_nom like '"+cbmat.getSelectedItem()+"'";
        String idmat=co.Retouridstring(cbmat,chmat,"mat_id");
        String chcl="select clas_id from classroom where clas_nom like '"+cbclasse.getSelectedItem()+"'";
        String idcl=co.Retouridstring(cbclasse,chcl,"clas_id");
        
        String chsql="SELECT * FROM professeur JOIN prof_clas_mat ON (prof_clas_mat.prof_id = professeur.prof_id) "+
" JOIN matiere ON (matiere.mat_id = prof_clas_mat.mat_id) "+

"JOIN classroom ON (classroom.clas_id = prof_clas_mat.clas_id)where prof_clas_mat.mat_id="+idmat+" and prof_clas_mat.clas_id="+idcl+"";
        ResultSet res= stmt.executeQuery(chsql);
        DefaultTableModel d=(DefaultTableModel) tbprof.getModel();
        while(d.getRowCount()>0){
                 d.removeRow(0);
            
        }

         while(res.next()){
           String nom =res.getString("prof_nom");
            String prenom =res.getString("prof_prenom");
            String email =res.getString("prof_email");
            String password =res.getString("prof_password");
            String tel =res.getString("prof_tel");

            String tbData[]={nom,prenom,email,password,tel};
            DefaultTableModel tbmodel=(DefaultTableModel) tbprof.getModel();
            tbmodel.addRow(tbData);
            }

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
        }

    } else if(checkmat.isSelected()){
            try{
            Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

String chmat="select mat_id from matiere where mat_nom like '"+cbmat.getSelectedItem()+"'";
        String idmat=co.Retouridstring(cbmat,chmat,"mat_id");
        
        String chsql="SELECT * FROM professeur JOIN prof_clas_mat ON (prof_clas_mat.prof_id = professeur.prof_id) " +
"JOIN matiere ON (matiere.mat_id = prof_clas_mat.mat_id) where prof_clas_mat.mat_id="+idmat+"";
        ResultSet res= stmt.executeQuery(chsql);
        DefaultTableModel d=(DefaultTableModel) tbprof.getModel();
        while(d.getRowCount()>0){
                 d.removeRow(0);
            
        }

         while(res.next()){
           String nom =res.getString("prof_nom");
            String prenom =res.getString("prof_prenom");
            String email =res.getString("prof_email");
            String password =res.getString("prof_password");
            String tel =res.getString("prof_tel");

            String tbData[]={nom,prenom,email,password,tel};
            DefaultTableModel tbmodel=(DefaultTableModel) tbprof.getModel();
            tbmodel.addRow(tbData);
            }

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
        }
        }else if(checkclas.isSelected()){
         try{
            Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();
       String chcl="select clas_id from classroom where clas_nom like '"+cbclasse.getSelectedItem()+"'";
        String idcl=co.Retouridstring(cbclasse,chcl,"clas_id");
        
        String chsql="SELECT * FROM professeur JOIN prof_clas_mat ON (prof_clas_mat.prof_id = professeur.prof_id) " +
"JOIN classroom ON (classroom.clas_id = prof_clas_mat.clas_id) where prof_clas_mat.clas_id="+idcl;
        ResultSet res= stmt.executeQuery(chsql);
        DefaultTableModel d=(DefaultTableModel) tbprof.getModel();
        while(d.getRowCount()>0){
                 d.removeRow(0);
            
        }

         while(res.next()){
           String nom =res.getString("prof_nom");
            String prenom =res.getString("prof_prenom");
            String email =res.getString("prof_email");
            String password =res.getString("prof_password");
            String tel =res.getString("prof_tel");
            String tbData[]={nom,prenom,email,password,tel};
            DefaultTableModel tbmodel=(DefaultTableModel) tbprof.getModel();
            tbmodel.addRow(tbData);
            }

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
        }
        
    }else{
                Remplitable();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbprof = new javax.swing.JTable();
        cbmat = new javax.swing.JComboBox<>();
        cbclasse = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        checkclas = new javax.swing.JCheckBox();
        checkmat = new javax.swing.JCheckBox();
        btna = new javax.swing.JButton();
        btnm = new javax.swing.JButton();
        btns = new javax.swing.JButton();
        btnc = new javax.swing.JButton();
        btnaff = new javax.swing.JButton();

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
        jLabel1.setText("Professeur");

        jButton1.setText("chercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbprof.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nom", "prenom", "email", "password", "telephone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbprof);
        if (tbprof.getColumnModel().getColumnCount() > 0) {
            tbprof.getColumnModel().getColumn(0).setResizable(false);
            tbprof.getColumnModel().getColumn(1).setResizable(false);
            tbprof.getColumnModel().getColumn(2).setResizable(false);
            tbprof.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel3.setText("Matiere");

        jLabel4.setText("classe");

        checkclas.setText("classe");
        checkclas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkclasActionPerformed(evt);
            }
        });

        checkmat.setText("Matiere");
        checkmat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkmatActionPerformed(evt);
            }
        });

        btna.setText("Ajouter");
        btna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaActionPerformed(evt);
            }
        });

        btnm.setText("Modifier");
        btnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmActionPerformed(evt);
            }
        });

        btns.setText("Supprimer");
        btns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsActionPerformed(evt);
            }
        });

        btnc.setText("Consulter");
        btnc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncActionPerformed(evt);
            }
        });

        btnaff.setText("Affecter");
        btnaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)
                        .addGap(48, 48, 48)
                        .addComponent(cbmat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44)
                        .addComponent(cbclasse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkmat)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkclas)
                                .addGap(69, 69, 69)
                                .addComponent(jButton1)))
                        .addGap(39, 39, 39))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btna)
                .addGap(78, 78, 78)
                .addComponent(btnaff)
                .addGap(82, 82, 82)
                .addComponent(btnm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btns)
                .addGap(83, 83, 83)
                .addComponent(btnc)
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(cbmat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbclasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(checkclas, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkmat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btna)
                    .addComponent(btnm)
                    .addComponent(btns)
                    .addComponent(btnc)
                    .addComponent(btnaff))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      rembtn();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkclasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkclasActionPerformed
        
    }//GEN-LAST:event_checkclasActionPerformed

    private void checkmatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkmatActionPerformed
     
    }//GEN-LAST:event_checkmatActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
rembtn();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsActionPerformed
       int row =tbprof.getSelectedRow();
        if(row>=0){
        String cell= tbprof.getModel().getValueAt(row, 2).toString();
        String chsql="delete from professeur where prof_email like '"+cell+"'";
         Connexion co=new Connexion();
         
             boolean res=co.ExecuterSQL(chsql);
        if(res==true){
        JOptionPane.showMessageDialog(this,"Supprimer avec succes");
        Remplitable();

        }else{
               JOptionPane.showMessageDialog(this,"Suppretion imposible");
}
        }else{
         JOptionPane.showMessageDialog(this,"veillez selectionner un client");}
         
    }//GEN-LAST:event_btnsActionPerformed

    private void btnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaActionPerformed
Addprof ae = new Addprof();
        ae.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaActionPerformed

    private void btncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncActionPerformed
         int row =tbprof.getSelectedRow();
         if(row>=0){
                     String cell= tbprof.getModel().getValueAt(row, 2).toString();
             Conprof mc=new Conprof();
             mc.setVisible(true);
         try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

        String chsql=" select * from professeur"
                + " where prof_EMAIL like '"+cell+"'";
        ResultSet res= stmt.executeQuery(chsql);

         if(res.next()){
            mc.txtemail.setText(res.getString("prof_EMAIL"));
            mc.txtpass.setText(res.getString("prof_PASSWORD"));
            mc.txtprenom.setText(res.getString("prof_PRENOM"));
            mc.txtnom.setText(res.getString("prof_NOM"));
            mc.txttel.setText(res.getString("prof_TEL"));
            mc.id=res.getString("prof_id");
                     
         } 
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
        }else{
         JOptionPane.showMessageDialog(this,"veillez selectionner un professeur");}
    }//GEN-LAST:event_btncActionPerformed

    private void btnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmActionPerformed
          int row =tbprof.getSelectedRow();
         if(row>=0){
                     String cell= tbprof.getModel().getValueAt(row, 2).toString();
             Modprof me=new Modprof();
             me.setVisible(true);
          //   me.Remcre();
         try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

        String chsql=" select *  from professeur"
                + " where prof_EMAIL like '"+cell+"'";
        ResultSet res= stmt.executeQuery(chsql);

         if(res.next()){
            me.txtemail.setText(res.getString("prof_EMAIL"));
            me.txtpass.setText(res.getString("prof_PASSWORD"));
            me.txtprenom.setText(res.getString("prof_PRENOM"));
            me.txtnom.setText(res.getString("prof_NOM"));
            me.txttel.setText(res.getString("prof_TEL"));
              me.idprof=res.getInt("prof_id");
       me.Remcre(res.getInt("prof_id"));
         }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
        }else{
         JOptionPane.showMessageDialog(this,"veillez selectionner un professeur");}
    }//GEN-LAST:event_btnmActionPerformed

    private void btnaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaffActionPerformed
        int row =tbprof.getSelectedRow();
         if(row>=0){
                     String cell= tbprof.getModel().getValueAt(row, 2).toString();
              Affprof ap =new Affprof();
       ap.setVisible(true);
         try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

        String chsql=" select *  from professeur"
                + " where prof_EMAIL like '"+cell+"'";
        ResultSet res= stmt.executeQuery(chsql);

         if(res.next()){
         
            ap.txtprenom.setText(res.getString("prof_PRENOM"));
            ap.txtnom.setText(res.getString("prof_NOM"));
       ap.idprof=Integer.parseInt(res.getString("prof_id"));
     
         }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
        }else{
         JOptionPane.showMessageDialog(this,"veillez selectionner un etudiant");}
                                       
    }//GEN-LAST:event_btnaffActionPerformed

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
            java.util.logging.Logger.getLogger(Allprof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Allprof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Allprof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Allprof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Allprof().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btna;
    private javax.swing.JButton btnaff;
    private javax.swing.JButton btnc;
    private javax.swing.JButton btnm;
    private javax.swing.JButton btns;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbclasse;
    private javax.swing.JComboBox<String> cbmat;
    private javax.swing.JCheckBox checkclas;
    private javax.swing.JCheckBox checkmat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbprof;
    // End of variables declaration//GEN-END:variables
}
