package br.com.controle;


import br.com.modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CategoriaDAO extends DAO {

    public void inserir(Categoria c) {
        try {
            abrirBanco();
            String query = "INSERT INTO categoria (id, nome) VALUES (null, ?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, c.getNome());
            pst.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editar(Categoria c) {
        try {
            abrirBanco();
            String query = "UPDATE categoria SET nome = ? WHERE id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, c.getNome());
            pst.setInt(2, c.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria atualizada!");
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Categoria buscarPorNome(String nome) {
    Categoria c = null;
    try {
        abrirBanco();
        String query = "SELECT * FROM categoria WHERE nome = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, nome);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            c = new Categoria();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
        }
        fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro ao buscar categoria: " + e.getMessage());
    }
    return c;
}

    public int inserirERetornarId(Categoria c) {
    int idGerado = -1;
    try {
        abrirBanco();
        String sql = "INSERT INTO categoria(nome) VALUES(?)";
        pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, c.getNome());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
        fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro ao inserir categoria: " + e.getMessage());
    }
    return idGerado;
}

    public ArrayList<Categoria> pesquisarTudo() {
        ArrayList<Categoria> lista = new ArrayList<>();
        try {
            abrirBanco();
            String query = "SELECT * FROM categoria";
            pst = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Categoria c;
            while (rs.next()) {
                c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }
}
