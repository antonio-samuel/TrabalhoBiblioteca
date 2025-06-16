package br.com.controle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class testprocedure {

    public static void main(String[] args) {
        // Chamada do método aqui, fora da definição dele
        testprocedurereListarLivros();
    }

    public static void testprocedurereListarLivros() {
        try {
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);

            CallableStatement stmt = con.prepareCall("{ CALL listar_livros_completo() }");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Sinopse: " + rs.getString("sinopse"));
                System.out.println("Valor: " + rs.getDouble("valor"));
                System.out.println("Categoria: " + rs.getString("nomeCategoria"));
                System.out.println("Autor: " + rs.getString("nomeAutor"));
                System.out.println("-----------");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao executar procedure: " + e.getMessage());
            e.printStackTrace();
        }
    }
}