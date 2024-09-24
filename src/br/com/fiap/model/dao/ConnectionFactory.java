package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Daniel Saburo Akiyama / RM: 558263
 * @author João Vitor Di Re / RM: 554749
 * @author Marcus Vila Nova / RM:
 * @author João Pedro R. / RM: 558199
 */
public class ConnectionFactory {
    public static Connection abrirConexao() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
            final String USER = "rm558263";
            final String PASS = "071005";
            con = DriverManager.getConnection(url, USER, PASS);
            // System.out.println("Conexão aberta.");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: A classe de conexão não foi encontrada!\n" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro de SQL!\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return con;
    }
    public static void fecharConexao(Connection con) {
        try {
            con.close();
            // System.out.println("Conexão fechada.");
        } catch (SQLException e) {
            System.out.println("Erro de SQL!\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

