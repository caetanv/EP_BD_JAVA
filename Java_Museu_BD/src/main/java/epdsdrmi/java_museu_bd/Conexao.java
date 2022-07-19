/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package epdsdrmi.java_museu_bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import jdk.internal.util.xml.impl.Input;

/**
 *
 * @author dell
 */
public class Conexao {    
    private Connection Conexao;
    private Statement Stmt;
    
    private void Executa() throws SQLException {
	Connect();
    }
    
    Conexao() throws SQLException{
        Connect();
    }
    
    private void Connect() throws SQLException{
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch(ClassNotFoundException e) {
            System.err.println("UcanaccessDriver Driver not found!");
        }
        try{
            Conexao = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/dell/Desktop/Museu.accdb");
            Stmt = Conexao.createStatement();
        }catch(SQLException e){
            System.err.println("Erro ao conectar");
        }
    }
    
    public void InsertArt(String Nome, Date nasc, Date mort, String pais, String periodo, String estilo, String desc) throws SQLException{
        PreparedStatement strComandoSQL ;
        strComandoSQL = Conexao.prepareStatement(
                        "INSERT INTO ARTISTA(Nome,DataNasc,DataMorte,PaisdeOrigem,PeriodoArt,EstiloPrincipal,Descricao)" +
                        " VALUES(?,?,?,?,?,?,?)");
			strComandoSQL.setString(1,Nome);
			strComandoSQL.setDate(2, nasc);
			strComandoSQL.setDate(3, mort);
			strComandoSQL.setString(4, pais);
			strComandoSQL.setString(5,periodo);
			strComandoSQL.setString(6,estilo);
			strComandoSQL.setString(7,desc);
			strComandoSQL.execute();
        Stmt.close();
        Conexao.close();
    }
                     
    public ResultSet CarregarQuery(String query) throws SQLException{
        ResultSet st = Stmt.executeQuery(query);
        return st;
    }

}
