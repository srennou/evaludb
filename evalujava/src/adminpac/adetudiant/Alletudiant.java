/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpac.adetudiant;

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
public class Alletudiant extends javax.swing.JFrame {

    
    public Alletudiant() {
        initComponents();
          remfil();
          remgrade();
        Remplitable();
       remclasse();

    }
    public void remfil(){
            String comfil="select fil_nom from filiere";
          Connexion.RempCombos(cbfil,comfil,"fil_nom");
    }
     public void remgrade(){
            String comgrade="select grad_nom from grade";
          Connexion.RempCombos(cbgrade,comgrade,"grad_nom");

    }
     public void remclasse(){
try{
       Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();
   
            String comcla="select clas_nom from classroom ";
          Connexion.RempCombos(cbclasse,comcla,"clas_nom");
 }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
    }
public  void Remplitable(){
    try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();
      
        String chsql="select *  from etudiant ";
        ResultSet res= stmt.executeQuery(chsql);
        DefaultTableModel d=(DefaultTableModel) tableetu.getModel();
        while(d.getRowCount()>0){
                 d.removeRow(0);
            
        }

         while(res.next()){
            String nom =res.getString("etu_nom");
            String prenom =res.getString("etu_prenom");
            String email =res.getString("etu_email");
            String password =res.getString("etu_password");
            String tel =res.getString("etu_tel");
            String date  =res.getString("etu_date_inscri");

            String tbData[]={nom,prenom,email,password,tel,date};
            DefaultTableModel tbmodel=(DefaultTableModel) tableetu.getModel();
            tbmodel.addRow(tbData);
            }

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
} 
public void rembtn(){
      if(checkfil.isSelected()){
            try{
            Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();
      String chfi="select fil_id from filiere where fil_nom like '"+cbfil.getSelectedItem()+"'";
        String idf=co.Retouridstring(cbfil,chfi,"fil_id");
String chg="select grad_id from grade where grad_nom like '"+cbgrade.getSelectedItem()+"'";
        String idg=co.Retouridstring(cbgrade,chg,"grad_id");
        
        String chsql="SELECT * FROM ETUDIANT JOIN classeroom_etudiant ON (classeroom_etudiant.etu_id = ETUDIANT.etu_id) " +
"JOIN classroom ON (classroom.clas_id = classeroom_etudiant.clas_id) where classroom.fil_id="+idf+" and classroom.grad_id="+idg+"";
        ResultSet res= stmt.executeQuery(chsql);
        DefaultTableModel d=(DefaultTableModel) tableetu.getModel();
        while(d.getRowCount()>0){
                 d.removeRow(0);
            
        }

         while(res.next()){
            String nom =res.getString("etu_nom");
            String prenom =res.getString("etu_prenom");
            String email =res.getString("etu_email");
            String password =res.getString("etu_password");
            String tel =res.getString("etu_tel");
            String date  =res.getString("etu_date_inscri");

            String tbData[]={nom,prenom,email,password,tel,date};
            DefaultTableModel tbmodel=(DefaultTableModel) tableetu.getModel();
            tbmodel.addRow(tbData);
            }

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
        }
        }else if(checkclas.isSelected()){
         try{
            Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();
       String chfi="select clas_id from classroom where clas_nom like '"+cbclasse.getSelectedItem()+"'";
        String idcl=co.Retouridstring(cbclasse,chfi,"clas_id");
        
        String chsql="SELECT * FROM ETUDIANT JOIN classeroom_etudiant ON (classeroom_etudiant.etu_id = ETUDIANT.etu_id) " +
"JOIN classroom ON (classroom.clas_id = classeroom_etudiant.clas_id) where classeroom_etudiant.clas_id="+idcl;
        ResultSet res= stmt.executeQuery(chsql);
        DefaultTableModel d=(DefaultTableModel) tableetu.getModel();
        while(d.getRowCount()>0){
                 d.removeRow(0);
            
        }

         while(res.next()){
            String nom =res.getString("etu_nom");
            String prenom =res.getString("etu_prenom");
            String email =res.getString("etu_email");
            String password =res.getString("etu_password");
            String tel =res.getString("etu_tel");
            String date  =res.getString("etu_date_inscri");

            String tbData[]={nom,prenom,email,password,tel,date};
            DefaultTableModel tbmodel=(DefaultTableModel) tableetu.getModel();
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
        tableetu = new javax.swing.JTable();
        cbfil = new javax.swing.JComboBox<>();
        cbgrade = new javax.swing.JComboBox<>();
        cbclasse = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        checkclas = new javax.swing.JCheckBox();
        checkfil = new javax.swing.JCheckBox();
        btna = new javax.swing.JButton();
        btnm = new javax.swing.JButton();
        btns = new javax.swing.JButton();
        btnc = new javax.swing.JButton();

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
        jLabel1.setText("Etudiants");

        jButton1.setText("chercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableetu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nom", "prenom", "email", "password", "telephone", "date inscription"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableetu);
        if (tableetu.getColumnModel().getColumnCount() > 0) {
            tableetu.getColumnModel().getColumn(0).setResizable(false);
            tableetu.getColumnModel().getColumn(1).setResizable(false);
            tableetu.getColumnModel().getColumn(2).setResizable(false);
            tableetu.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setText("filiere");

        jLabel3.setText("grade");

        jLabel4.setText("classe");

        checkclas.setText("classe");
        checkclas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkclasActionPerformed(evt);
            }
        });

        checkfil.setText("filiere,grade");
        checkfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkfilActionPerformed(evt);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbfil, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbclasse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkfil)
                            .addComponent(checkclas))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(39, 39, 39))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btna)
                .addGap(94, 94, 94)
                .addComponent(btnm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btns)
                .addGap(126, 126, 126)
                .addComponent(btnc)
                .addGap(95, 95, 95))
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
                        .addComponent(cbfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbgrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbclasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(checkclas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkfil)))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btna)
                    .addComponent(btnm)
                    .addComponent(btns)
                    .addComponent(btnc))
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
        if(checkclas.isSelected()){
            checkfil.setSelected(false);
        }
    }//GEN-LAST:event_checkclasActionPerformed

    private void checkfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkfilActionPerformed
        if(checkfil.isSelected()){
            checkclas.setSelected(false);}
    }//GEN-LAST:event_checkfilActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
rembtn();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsActionPerformed
       int row =tableetu.getSelectedRow();
        if(row>=0){
        String cell= tableetu.getModel().getValueAt(row, 2).toString();
        String chsql="delete from etudiant where etu_email like '"+cell+"'";
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
Addetudiant ae = new Addetudiant();
        ae.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaActionPerformed

    private void btncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncActionPerformed
         int row =tableetu.getSelectedRow();
         if(row>=0){
                     String cell= tableetu.getModel().getValueAt(row, 2).toString();
             Consetudiant mc=new Consetudiant();
             mc.setVisible(true);
         try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

        String chsql=" select ETU_ID ,ETU_EMAIL ,ETU_PASSWORD ,ETU_NOM ,ETU_PRENOM ,ETU_TEL ,ETU_DATE_INSCRI  from etudiant"
                + " where ETU_EMAIL like '"+cell+"'";
        ResultSet res= stmt.executeQuery(chsql);

         if(res.next()){
            mc.txtemail.setText(res.getString("ETU_EMAIL"));
            mc.txtpass.setText(res.getString("ETU_PASSWORD"));
            mc.txtprenom.setText(res.getString("ETU_PRENOM"));
            mc.txtnom.setText(res.getString("ETU_NOM"));
            mc.txttel.setText(res.getString("ETU_TEL"));
            mc.txtdate.setText(res.getString("ETU_DATE_INSCRI"));
            try{
        Connexion cod =new Connexion();
        Statement stmtd=cod.con.createStatement();

        String chsqld=" SELECT * FROM classroom JOIN classeroom_etudiant ON (classeroom_etudiant.clas_id = classroom.clas_id) " +
"JOIN etudiant ON (etudiant.etu_id = classeroom_etudiant.etu_id) where classeroom_etudiant.etu_id="+res.getString("etu_id");
        ResultSet resd= stmt.executeQuery(chsqld);

         if(resd.next()){
            mc.txtclas.setText(resd.getString("clas_nom"));
           
           
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
    }//GEN-LAST:event_btncActionPerformed

    private void btnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmActionPerformed
          int row =tableetu.getSelectedRow();
         if(row>=0){
                     String cell= tableetu.getModel().getValueAt(row, 2).toString();
             Modifieretudiant me=new Modifieretudiant();
             me.setVisible(true);
         try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();

        String chsql=" select ETU_ID ,ETU_EMAIL ,ETU_PASSWORD ,ETU_NOM ,ETU_PRENOM ,ETU_TEL ,ETU_DATE_INSCRI  from etudiant"
                + " where ETU_EMAIL like '"+cell+"'";
        ResultSet res= stmt.executeQuery(chsql);

         if(res.next()){
            me.txtemail.setText(res.getString("ETU_EMAIL"));
            me.txtpass.setText(res.getString("ETU_PASSWORD"));
            me.txtprenom.setText(res.getString("ETU_PRENOM"));
            me.txtnom.setText(res.getString("ETU_NOM"));
            me.txttel.setText(res.getString("ETU_TEL"));
            me.txtdate.setText(res.getString("ETU_DATE_INSCRI"));
              me.idetu=res.getInt("etu_id");
            try{
        Connexion cod =new Connexion();
        Statement stmtd=cod.con.createStatement();

        String chsqld=" SELECT * FROM classroom JOIN classeroom_etudiant ON (classeroom_etudiant.clas_id = classroom.clas_id) " +
"JOIN etudiant ON (etudiant.etu_id = classeroom_etudiant.etu_id) where classeroom_etudiant.etu_id="+res.getString("etu_id");
        ResultSet resd= stmtd.executeQuery(chsqld);

         if(resd.next()){
            me.cbclasm.setSelectedItem(resd.getString("clas_nom"));
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
    }//GEN-LAST:event_btnmActionPerformed

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
            java.util.logging.Logger.getLogger(Alletudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alletudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alletudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alletudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alletudiant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btna;
    private javax.swing.JButton btnc;
    private javax.swing.JButton btnm;
    private javax.swing.JButton btns;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbclasse;
    private javax.swing.JComboBox<String> cbfil;
    private javax.swing.JComboBox<String> cbgrade;
    private javax.swing.JCheckBox checkclas;
    private javax.swing.JCheckBox checkfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableetu;
    // End of variables declaration//GEN-END:variables
}
