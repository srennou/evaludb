/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profpac;

import connexion.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MBS
 */
public class InfoExam extends javax.swing.JFrame {
   public int idcl,idmat,profi;

    /**
     * Creates new form InfoExam
     */
    public InfoExam() {
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
        txtnom = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        btnques = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Exam");

        jLabel142.setText("nom d'exam");

        jLabel143.setText("numero d'exam");

        btnques.setText("Ajouter des question");
        btnques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel142)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel143)
                        .addGap(18, 18, 18)
                        .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnques)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel143)
                    .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(btnques)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquesActionPerformed
         int valexam=1;
        try{
        Connexion co =new Connexion();
        Statement stmt=co.con.createStatement();
      
        String chsql="select exam_seq.nextval  from dual ";
        ResultSet res= stmt.executeQuery(chsql);
   

         while(res.next()){
             valexam =res.getInt("nextval");


            }

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }
        
        
        
        Newexam ne=new Newexam();
        ne.setVisible(true);
      
             Connexion com = new Connexion();
        try{
            Statement stmtm = com.con.createStatement();
           
            String chsqml="insert into exam(exam_id,mat_id,exam_nom,exam_num)values( "+valexam+","+idmat+",'"+txtnom.getText()+"',"+Integer.parseInt(txtnum.getText())+")";
            int nblignem = stmtm.executeUpdate(chsqml);
               
           Connexion co = new Connexion();
        try{
            Statement stmt = co.con.createStatement();
           
            String chsql="insert into classroom_matiere(clas_id,prof_id,exam_id)values( "+idcl+","+profi+","+valexam+")";
            int nbligne = stmt.executeUpdate(chsql);
            
            
        }catch(SQLException e){

            JOptionPane.showMessageDialog(this, "error"+e.getMessage());
        }
            
            
        }catch(SQLException e){

            JOptionPane.showMessageDialog(this, "error"+e.getMessage());
        }
         /*   try{
        Connexion cod =new Connexion();
        Statement stmtd=cod.con.createStatement();

        String chsqld=" select exam_seq.currval from dual ";
        ResultSet resd= stmtd.executeQuery(chsqld);

         if(resd.next()){*/
            ne.idexam=valexam;//resd.getInt("exam_seq.currval");
           dispose();
        /* }
            

    }catch(SQLException e){
        JOptionPane.showMessageDialog(this,"error "+e.getMessage());
    }*/
         
    }//GEN-LAST:event_btnquesActionPerformed

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
            java.util.logging.Logger.getLogger(InfoExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnques;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnum;
    // End of variables declaration//GEN-END:variables
}
