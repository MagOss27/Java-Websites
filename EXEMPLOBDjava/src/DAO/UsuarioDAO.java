package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Usuario;

public class UsuarioDAO {

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES (?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para editar o usuário
    public void editarUsuario(Usuario usuario) {
        String sql = "UPDATE USUARIO SET NOME = ?, LOGIN = ?, SENHA = ?, EMAIL = ? WHERE IDUSUARIO = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());
            ps.setInt(5, usuario.getIdusuario());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o ID fornecido.");
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar usuário por nome e senha
    public Usuario buscarUsuarioPorNomeESenha(String nome, String senha) {
        String sql = "SELECT * FROM USUARIO WHERE NOME = ? AND SENHA = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("IDUSUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setEmail(rs.getString("EMAIL"));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
