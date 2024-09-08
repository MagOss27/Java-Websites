package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Usuario;

public class UsuarioDAO {

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (NOME, SENHA, EMAIL) VALUES (?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para editar o usuário
    public void editarUsuario(Usuario usuario) {
        String sql = "UPDATE USUARIO SET NOME = ?, SENHA = ?, EMAIL = ? WHERE IDUSUARIO = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getIdusuario());

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

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM USUARIO";
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("IDUSUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuarios.add(usuario);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Método para apagar um usuário
    public void apagarUsuario(int idusuario) {
        String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idusuario);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário apagado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o ID fornecido.");
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
