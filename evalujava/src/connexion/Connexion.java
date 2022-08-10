/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;
import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.JButton;

/**
 *
 * @author srennou
 */
public class Connexion {
     final String url="jdbc:oracle:thin:EVALUDB/test@localhost:1521:XE";
     public Connection con=null;
     String info=null;
         public Connexion(){
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.con=DriverManager.getConnection(url);

                }
        catch(ClassNotFoundException e){
            this.info+=" erreur de chargement de pilote"+e.getMessage();
        }        catch(SQLException e){
            this.info+=" imposible de se connecter "+e.getMessage()+"/n";
        }

    }
         public   void getInfo(JButton btn){
         btn.setText( info);}
         
         public void Deconnexion(){
        try{
        this.con.close();
        this.con=null;
        }
        catch(NullPointerException e){
            info="pas de connection "+e.getMessage();
        }
        catch(SQLException e){
           info+="pas de connection "+e.getMessage();
        }
    }

         public boolean ExecuterSQL(String chsql){
          try{
            Connexion cn =new Connexion();
            Statement stmt = cn.con.createStatement();
            int nbligne = stmt.executeUpdate(chsql);
            return true;
         }  catch(SQLException e){
            return false;
        }}
         public boolean Executerinsert(String chsql){
          try{
            Connexion cn =new Connexion();
            Statement stmt = cn.con.createStatement();
           ResultSet res=stmt.executeQuery(chsql);
        if(res.next()){
       return true;
          
        }  else
            return false;
         }  catch(SQLException e){
            return false;
        }
          
         }
         
         JComboBox cbo =new JComboBox();
         public static void RempCombos(JComboBox cbo,String chsql,String champ){
         try{
        Connexion cn = new Connexion();
  cbo.removeAllItems();
          Statement instr = cn.con.createStatement();
            ResultSet res = instr.executeQuery(chsql);
            while(res.next()){
                cbo.addItem(res.getString(""+champ+""));
            }
            

 }catch(SQLException ex){
            cbo.addItem("aucun element");
            }
         }
         
         
         


         
                public String Retouridstring(JComboBox cbo,String chsql,String champ){
         String id =null;
         try{
         Connexion cn = new Connexion();
          Statement instr = cn.con.createStatement();
            ResultSet res = instr.executeQuery(chsql);
            if(res.next()){
                id=res.getString(""+champ+"");
            }
         return id;
         
         
         }catch(SQLException ex){
            return null;
         }
         
         }
        
}
