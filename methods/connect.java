/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import methods.TableFromDatabase;

/**
 *
 * @author hfpma
 */
public class connect {

    public Connection conStart() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // denken Sie bitte daran, dass Passwort hier einzutragen!
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/fapair2_2?user=java&password=java");
            System.out.println("I'm drin!");
            return conn;
        } catch (Exception e) {
            System.out.println("Mistake while connecting to DB!");
            System.out.println("VERBINDUNG!");
            System.out.println("Fehlermeldung: " + e);
        }

        return null;
    }

    
    
    
    
   /* public void createTable(){
        JTable newtable = new JTable( );
        newtable=TableFromDatabase();
    }*/
 

    public String [] ReadOutDB(String str) {
        ArrayList<String> list = new ArrayList<>();

        try {
            Connection conn = this.conStart();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(str);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Fehler in ReadoutDB");
            System.out.println("VERBINDUNG");
            System.out.println("Fehler: " + e);
        }
                
                String[] index = list.toArray(new String[list.size()]);
        return index;
    }
    
    public String ReadOutString(String str) {
        ArrayList<String> list = new ArrayList<>();

        try {
            Connection conn = this.conStart();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(str);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Fehler in ReadoutDB");
            System.out.println("VERBINDUNG");
            System.out.println("Fehler: " + e);
        }
                
                String[] index = list.toArray(new String[list.size()]);
                String help=index[0];
        return help;
    }

    public boolean InsertInDB(String tmpText) {
        try {
            Connection conn = this.conStart();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO testemich VALUES ('" + tmpText + "')");
            return true;
        } catch (Exception e) {
            System.out.println("Fehler in InsertInDB");
            System.out.println("VERBINDUNG");
            System.out.println("Fehler: " + e);
            return false;
        }

    }
    
    
    
}
