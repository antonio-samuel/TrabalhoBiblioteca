package br.com.controle;


import br.com.modelo.Livro;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LivroDAO extends DAO {

    public void inserir(Livro l) throws java.sql.SQLException {
    try {
        abrirBanco(); 
        con.setAutoCommit(false); // Desativa auto-commit

        System.out.println("Inserindo livro no banco...");

        String query = "INSERT INTO livro (titulo, sinopse, valor, id_categoria, id_autor) VALUES (?, ?, ?, ?, ?)";
        pst = con.prepareStatement(query);
        pst.setString(1, l.getTitulo());
        pst.setString(2, l.getSinopse());
        pst.setDouble(3, l.getValor());
        pst.setInt(4, l.getIdCategoria());
        pst.setInt(5, l.getIdAutor());

        int rowsAffected = pst.executeUpdate(); 

        if (rowsAffected > 0) {
            con.commit(); // Confirma a transação
            System.out.println("Livro inserido com sucesso!");
        } else {
            con.rollback(); // Desfaz alterações caso nada seja inserido
            System.out.println("Falha ao inserir o livro.");
        }

        pst.close();
        fecharBanco(); // Certifique-se de que fecha corretamente

    } catch (Exception e) {
        con.rollback(); // Garante que nenhuma alteração fique no banco em caso de erro
        System.out.println("Erro: " + e.getMessage());
    }
}

    public void deletar(Livro l) {
        try {
            abrirBanco();
            String query = "DELETE FROM livro WHERE id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, l.getId());
            pst.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public ArrayList<Livro> pesquisarTudo() {
        ArrayList<Livro> lista = new ArrayList<>();
        try {
            abrirBanco();
            String query = "SELECT * FROM livro";
            pst = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Livro l;
            while (rs.next()) {
                l = new Livro();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setSinopse(rs.getString("sinopse"));
                l.setValor(rs.getDouble("valor"));
                l.setIdCategoria(rs.getInt("id_categoria"));
                l.setIdAutor(rs.getInt("id_autor"));
                lista.add(l);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public void pesquisarPorId(Livro l) {
        try {
            abrirBanco();
            String query = "SELECT * FROM livro WHERE id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, l.getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                l.setTitulo(rs.getString("titulo"));
                l.setSinopse(rs.getString("sinopse"));
                l.setValor(rs.getDouble("valor"));
                l.setIdCategoria(rs.getInt("id_categoria"));
                l.setIdAutor(rs.getInt("id_autor"));
            } else {
                JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
   public ArrayList<Livro> pesquisarComCategoriaENomeAutor() throws Exception {
    ArrayList<Livro> lista = new ArrayList<>();
    try {
        abrirBanco();
        String query = """
            SELECT l.id, l.titulo, l.sinopse, l.valor,
                   c.nome AS nomeCategoria,
                   a.nome AS nomeAutor
            FROM livro l
            INNER JOIN categoria c ON l.id_categoria = c.id
            INNER JOIN autor a ON l.id_autor = a.id
        """;

        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            Livro l = new Livro();
            l.setId(rs.getInt("id"));
            l.setTitulo(rs.getString("titulo"));
            l.setSinopse(rs.getString("sinopse"));
            l.setValor(rs.getDouble("valor"));
            l.setNomeCategoria(rs.getString("nomeCategoria"));
            l.setNomeAutor(rs.getString("nomeAutor"));
            lista.add(l);
        }

        fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro ao listar livros: " + e.getMessage());
    }

    return lista;
}


    public void editar(Livro l) {
        try {
            abrirBanco();
            String query = "UPDATE livro SET titulo = ?, sinopse = ?, valor = ?, id_categoria = ?, id_autor = ? WHERE id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, l.getTitulo());
            pst.setString(2, l.getSinopse());
            pst.setDouble(3, l.getValor());
            pst.setInt(4, l.getIdCategoria());
            pst.setInt(5, l.getIdAutor());
            pst.setInt(6, l.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        

    }
    public ArrayList<Livro> listarLivrosComProcedure() {
    ArrayList<Livro> lista = new ArrayList<>();
    
    try {
        DAO dao = new DAO();
        CallableStatement stmt = (CallableStatement) con.prepareCall("{ call listar_livros_completo() }");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Livro l = new Livro();
            l.setId(rs.getInt("id"));
            l.setTitulo(rs.getString("titulo"));
            l.setSinopse(rs.getString("sinopse"));
            l.setValor(rs.getDouble("valor"));
            l.setNomeCategoria(rs.getString("nomeCategoria"));
            l.setNomeAutor(rs.getString("nomeAutor"));
            
            lista.add(l);
        }
        
        rs.close();
        stmt.close();
        con.close();
    } catch (Exception e) {
        System.out.println("Erro ao listar livros com procedure: " + e.getMessage());
    }
    
    return lista;
}


    private static class SQLException {

        public SQLException() {
        }
    }
}

