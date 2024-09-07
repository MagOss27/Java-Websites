import DAO.UsuarioDAO;
import entity.Usuario;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar novo usuário");
        System.out.println("2 - Editar usuário existente");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (opcao == 1) {
            // Cadastrar novo usuário
            Usuario u = new Usuario();
            
            System.out.println("Cadastro de Usuário");

            System.out.print("Digite o nome: ");
            u.setNome(scanner.nextLine());
            
            System.out.print("Digite o login: ");
            u.setLogin(scanner.nextLine());
            
            System.out.print("Digite a senha: ");
            u.setSenha(scanner.nextLine());
            
            System.out.print("Digite o email: ");
            u.setEmail(scanner.nextLine());
            
            usuarioDAO.cadastrarUsuario(u);
            System.out.println("Usuário cadastrado com sucesso!");

        } else if (opcao == 2) {
            // Editar usuário existente
            System.out.println("Edição de Usuário");

            System.out.print("Digite o nome do usuário: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a senha do usuário: ");
            String senha = scanner.nextLine();

            // Verificar se o usuário existe com base no nome e senha
            Usuario usuario = usuarioDAO.buscarUsuarioPorNomeESenha(nome, senha);
            if (usuario != null) {
                System.out.println("Usuário encontrado! O que você deseja editar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Login");
                System.out.println("3 - Senha");
                System.out.println("4 - Email");
                System.out.println("5 - Todos os campos");

                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (escolha) {
                    case 1:
                        System.out.print("Digite o novo nome: ");
                        usuario.setNome(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Digite o novo login: ");
                        usuario.setLogin(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Digite a nova senha: ");
                        usuario.setSenha(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Digite o novo email: ");
                        usuario.setEmail(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Digite o novo nome: ");
                        usuario.setNome(scanner.nextLine());

                        System.out.print("Digite o novo login: ");
                        usuario.setLogin(scanner.nextLine());

                        System.out.print("Digite a nova senha: ");
                        usuario.setSenha(scanner.nextLine());

                        System.out.print("Digite o novo email: ");
                        usuario.setEmail(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                // Atualizar o usuário no banco de dados
                usuarioDAO.editarUsuario(usuario);

            } else {
                System.out.println("Usuário ou senha incorretos.");
            }

        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
