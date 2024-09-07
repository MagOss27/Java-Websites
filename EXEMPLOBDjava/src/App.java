import DAO.UsuarioDAO;
import entity.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Usuario u = new Usuario();
        u.setNome("Magnus"); // Corrigido para remover 'nome:'
        u.setLogin("magnus"); // Corrigido para remover 'login:'
        u.setSenha("1234"); // Corrigido para remover 'senha:'
        u.setEmail("magnusoss@gmail.com"); // Corrigido para remover 'email:'

        new UsuarioDAO().cadastrarUsuario(u);
    }
}
