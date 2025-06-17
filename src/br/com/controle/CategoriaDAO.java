package br.com.controle;


import br.com.modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CategoriaDAO extends DAO {

    public boolean inserirCategoria(Categoria c) {
       try {
    abrirBanco();
    System.out.println("Banco conectado!");
    String query = "INSERT INTO categoria (nome) VALUES (?)";
    try (PreparedStatement pst = con.prepareStatement(query)) {
        pst.setString(1, c.getNome());
        System.out.println("Executando SQL...");
        int linhasAfetadas = pst.executeUpdate();
        System.out.println("Linhas afetadas: " + linhasAfetadas);
        fecharBanco();
        return linhasAfetadas > 0;
    }
  } catch (Exception ex) {
    System.err.println("Erro geral: " + ex.getMessage());
}
        return false;


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
      public void deletar(Categoria a) {
        try {
            abrirBanco();
            String query = "DELETE FROM categoria WHERE id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.execute();
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
    
    public int buscarIdPorNome(String nome) throws Exception, Exception {
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

    private static class SQLException {

        public SQLException() {
        }
    }
    public class CadastroCategoriaDAO {

    public boolean categoriaExiste(String nome) throws Exception {
        String query = "SELECT COUNT(*) FROM categoria WHERE nome = ?";

        abrirBanco();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nome);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Categoria já existe
                }
            }
        }
        fecharBanco();
        return false; // Categoria não encontrada
    }

    public boolean cadastrarCategoria(String nome) throws Exception {
        if (categoriaExiste(nome)) {
            System.out.println("Erro: Categoria já cadastrada!");
            return false;
        }

        String query = "INSERT INTO categoria (nome) VALUES (?)";
        abrirBanco();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nome);
            pst.executeUpdate();
        }
        fecharBanco();
        return true;
    }
    }
      public boolean categoriaExiste(String nome) throws java.sql.SQLException, Exception {
        String query = "SELECT COUNT(*) FROM categoria WHERE nome = ?";

        abrirBanco();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nome);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Categoria já existe
                }
            }
        }
        fecharBanco();
        return false; // Categoria não encontrada
    }

    public boolean cadastrarCategoria(String nome) throws java.sql.SQLException, Exception {
        if (categoriaExiste(nome)) {
            System.out.println("Erro: Categoria já cadastrada!");
            return false;
        }

        String query = "INSERT INTO categoria (nome) VALUES (?)";
        abrirBanco();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nome);
            pst.executeUpdate();
        }
        fecharBanco();
        return true;
    }
    
    public void atualizarNome(int id, String novoNome) {
    try {
        abrirBanco();
        String sql = "UPDATE categoria SET nome = ? WHERE id = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, novoNome);
        pst.setInt(2, id);
        pst.executeUpdate();
        fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro ao atualizar nome da categoria: " + e.getMessage());
    }
}

    public Categoria pesquisarRegistro(String criterio) throws Exception {
    Categoria categoria = null;
    String query = "SELECT * FROM categoria WHERE id = ? OR nome LIKE ?";

    abrirBanco();
    try (PreparedStatement pst = con.prepareStatement(query)) {
        // Se o critério for número, tenta pesquisar por ID; senão, pesquisa por nome
        try {
            pst.setInt(1, Integer.parseInt(criterio));
        } catch (NumberFormatException e) {
            pst.setNull(1, java.sql.Types.INTEGER);
        }
        pst.setString(2, "%" + criterio + "%");
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
            }
        }
    }
    fecharBanco();

    return categoria;
}

     public boolean alterarRegistro(Categoria categoria) throws Exception {
    String query = "UPDATE categoria SET nome = ? WHERE id = ?";
    boolean sucesso = false;

    try {
        abrirBanco();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, categoria.getNome());
            pst.setInt(2, categoria.getId());

            int linhasAfetadas = pst.executeUpdate();
            sucesso = linhasAfetadas > 0;
        }
    } finally {
        fecharBanco(); // Sempre será executado, mesmo se ocorrer erro
    }

    return sucesso;
}

    }

