/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package epdsdrmi.java_museu_bd;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class Java_Museu_BD {

    public static void main(String[] args) throws SQLException {
        MUSEU_GUI museu = new MUSEU_GUI();
        museu.setVisible(true);
        Conexao c = new Conexao();
    }
    
}
