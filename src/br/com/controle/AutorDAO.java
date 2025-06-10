package br.com.controle;


import br.com.modelo.Autor;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AutorDAO extends DAO {

    public void inserir(Autor a) {
        try {
            abrirBanco();
            String query = "INSERT INTO autor (id, nome) VALUES (null, ?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getNome());
            pst.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void deletar(Autor a) {
        try {
            abrirBanco();
            String query = "DELETE FROM autor WHERE id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public Autor buscarPorNome(String nome) {
    Autor a = null;
    try {
        abrirBanco();
        String query = "SELECT * FROM autor WHERE nome = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, nome);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            a = new Autor();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
        }
        fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro ao buscar autor: " + e.getMessage());
    }
    return a;
}

    public int inserirERetornarId(Autor a) {
    int idGerado = -1;
    try {
        abrirBanco();
        String query = "INSERT INTO autor(nome) VALUES(?)";
        pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS );
        pst.setString(1, a.getNome());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
        fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro ao inserir autor: " + e.getMessage());
    }
    return idGerado;
}


    public ArrayList<Autor> pesquisarTudo() {
        ArrayList<Autor> lista = new ArrayList<>();
        try {
            abrirBanco();
            String query = "SELECT * FROM autor";
            pst = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Autor a;
            while (rs.next()) {
                a = new Autor();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                lista.add(a);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }
}

