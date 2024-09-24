import java.util.Scanner;
import java.util.Stack;

public class TestaPilha2 {
    public static void main(String[] args) {
        boolean run = true;

        Scanner scanner = new Scanner(System.in);

        Stack<Contato> contatos = new Stack<>();

        while (run) {
            System.out.println("""
                    Selecione uma opçãp: \
                    
                    1. Adicionar elemento - Empilhar (no topo da pilha) \
                    2. Verificar o tamanho da pilha \
                    3. Imprimir elementos da pilha (desempilhando) \
                    4. Topo da pilha (exibir o elemento no topo da pilha) \
                    5. Verificar se elemento existe na pilha e retornar a posição \
                    6. Pesquisar por nome \
                    7. Pesquisar por e-mail \
                    8. Pesquisar por telefone \
                    9. Excluir elemento - Desempilhar \
                    0. Sair\s""");

            scanner.nextLine();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    run = false;

                case 1:
                    System.out.println("Insira o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.println("Insira o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Insira o email do contato: ");
                    String email = scanner.nextLine();

                    contatos.push(new Contato(nome, telefone, email));
                    break;

                case 2:
                    System.out.println("Tamanho da pilha de contatos: " + contatos.capacity());
                    break;

                case 3:
                    System.out.println(contatos);
                    break;

                case 4:
                    System.out.println("Topo da pilha: " + contatos.peek());
                    break;

                case 5:
                    System.out.println("Insira o nome do contato: ");
                    String nome_verificar = scanner.nextLine();
                    System.out.println("Insira o telefone do contato: ");
                    String telefone_verificar = scanner.nextLine();
                    System.out.println("Insira o email do contato: ");
                    String email_verificar = scanner.nextLine();

                    if (contatos.contains(new Contato(nome_verificar, telefone_verificar, email_verificar))) {
                        System.out.println("Posição do contato: " + contatos.search(new Contato(nome_verificar,
                                                                                                telefone_verificar,
                                                                                                email_verificar)));
                        break;
                    }
                    System.out.println("Contato não existe");
                    break;

                case 6:
                    System.out.println("Insira o nome do contato");
                    String nome_busca = scanner.nextLine();

                    System.out.println(contatos.get(contatos.search(new Contato(nome_busca, "", ""))));
                    break;

                case 7:
                    System.out.println("Insira o telefone do contato");
                    String telefone_busca = scanner.nextLine();

                    System.out.println(contatos.get(contatos.search(new Contato("", telefone_busca, ""))));
                    break;

                case 8:
                    System.out.println("Insira o email do contato");
                    String email_busca = scanner.nextLine();

                    System.out.println(contatos.get(contatos.search(new Contato("", "", email_busca))));
                    break;

                case 9:
                    contatos.pop();
                    System.out.println("Último elemento excluído");
                    break;
            }
        }
    }
}
