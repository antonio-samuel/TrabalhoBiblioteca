package br.com.controle;


import br.com.modelo.Autor;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AutorDAO extends DAO {

   public boolean inserir(Autor a) {
    String query = "INSERT INTO autor (nome) VALUES (?)"; // O ID será gerado automaticamente

    try {
        abrirBanco();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, a.getNome());
            int linhasAfetadas = pst.executeUpdate(); // Retorna o número de linhas modificadas
            fecharBanco();
            return linhasAfetadas > 0; // Retorna true se a inserção for bem-sucedida
        } catch (Exception ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (SQLException e) {
        System.err.println("Erro ao cadastrar autor: " + e.getMessage());
    }
    return false; // Retorna false caso haja erro
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
    
    public int buscarIdPorNome(String nome) throws SQLException, Exception {
    abrirBanco();
    int id = -1;
    try {
        String sql = "SELECT id FROM categoria WHERE nome = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nome);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }
        rs.close();
        pst.close();
    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
    fecharBanco();
    return id;
}
    
    public boolean alterarRegistro(Autor autor) throws Exception {
    String query = "UPDATE autor SET nome = ? WHERE id = ?";

    try {
        abrirBanco();

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, autor.getNome()); // Define o novo nome
            pst.setInt(2, autor.getId());      // Define o ID para encontrar o autor

            int linhasAfetadas = pst.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se pelo menos uma linha foi alterada
        }

    } catch (SQLException e) {
        System.err.println("Erro ao alterar autor: " + e.getMessage());
        return false;
    } finally {
        fecharBanco();
    }
    
    /**
     *
     * @param nome
     * @return
     * @throws Exception
     */
  
}public boolean autorExiste(String nome) throws Exception {
    String query = "SELECT COUNT(*) FROM autor WHERE nome = ?";

    try {
        abrirBanco();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nome);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Autor já existe
                }
            }
        }
    } catch (SQLException e) {
        System.err.println("Erro ao verificar autor: " + e.getMessage());
    } finally {
        fecharBanco();
    }
    return false; // Autor não encontrado
}
public Autor pesquisarRegistro(String criterio) throws Exception {
    Autor autor = null;
    String query = "SELECT * FROM autor WHERE id = ? OR nome LIKE ?";

    try {
        abrirBanco();

        try (PreparedStatement pst = con.prepareStatement(query)) {
            // Se o usuário digitar um número, pesquisa por ID; se for texto, pesquisa por Nome
            try {
                pst.setInt(1, Integer.parseInt(criterio));
            } catch (NumberFormatException e) {
                pst.setNull(1, java.sql.Types.INTEGER);
            }
            pst.setString(2, "%" + criterio + "%");

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    autor = new Autor();
                    autor.setId(rs.getInt("id"));
                    autor.setNome(rs.getString("nome"));
                }
            }
        }

        fecharBanco();

    } catch (SQLException e) {
        System.err.println("Erro ao pesquisar autor: " + e.getMessage());
    }

    return autor;
}
}


