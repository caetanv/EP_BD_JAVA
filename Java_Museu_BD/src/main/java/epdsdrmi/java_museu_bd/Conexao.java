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

/**
 *
 * @author dell
 */
public class Conexao {    
    private Connection Conexao;
    private Statement Comando;
    
    private void Executa() throws SQLException {
	Connect();
    }
    
    Conexao() throws SQLException{
        Connect();
        Carregar();
    }
    
    private void Connect() throws SQLException{
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch(ClassNotFoundException e) {
            System.err.println("JdbcOdbc Bridge Driver not found!");
        }
        try{
            Conexao = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.accdb)};DBQ=C:/Users/dell/Desktop/Museu.accdb");
            Comando = Conexao.createStatement();
        }catch(SQLException e){
            System.err.println("Erro ao conectar");
        }
    }
    
    public void Insert() throws SQLException{
        PreparedStatement strComandoSQL ;
        strComandoSQL = Conexao.prepareStatement(
                        "INSERT INTO ARTISTA(Nome,DataNasc,DataMorte,PaisdeOrigem,PeriodoArt,EstiloPrincipal,Descricao)" +
                        " VALUES(?,?,?,?,?,?,?)");
        
			strComandoSQL.setString(1,"Teste");
			strComandoSQL.setDate(2, new Date(0));
			strComandoSQL.setDate(3, new Date(0));
			strComandoSQL.setString(4,"Teste Pais");
			strComandoSQL.setString(5,"Teste PeriodoArt");
			strComandoSQL.setString(6,"Teste EstiloPrincipal");
			strComandoSQL.setString(7,"Teste Descricao");
			int intRegistro = strComandoSQL.executeUpdate();
                        if (intRegistro != 0)
                        JOptionPane.showMessageDialog(null,"Registro adicionado !",
                                               "Mensagem",JOptionPane.INFORMATION_MESSAGE);
        Comando.close();
        Conexao.close();
    }
                     
    public void Carregar() throws SQLException{
        Statement stmt = Conexao.createStatement();
        ResultSet st = stmt.executeQuery("Select * from ARTISTA");
    }
    
}
