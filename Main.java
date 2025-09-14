package eventsystem;

import java.util.*;
import java.time.LocalDateTime;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static EventManager manager = new EventManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Sistema de Eventos ====");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Cadastrar evento");
            System.out.println("3. Listar eventos futuros");
            System.out.println("4. Participar de evento");
            System.out.println("5. Cancelar participação");
            System.out.println("6. Eventos passados");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> cadastrarEvento();
                case 3 -> listarEventosFuturos();
                case 4 -> participarEvento();
                case 5 -> cancelarParticipacao();
                case 6 -> listarEventosPassados();
                case 7 -> {
                    manager.salvar();
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Categoria (ex: Estudante): ");
        String categoria = sc.nextLine();
        manager.cadastrarUsuario(new User(nome, endereco, categoria));
    }

    private static void cadastrarEvento() {
        System.out.print("Nome do evento: ");
        String nome = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Categoria (FESTA, ESPORTIVO, SHOW, OUTRO): ");
        Category categoria = Category.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
        LocalDateTime horario = EventManager.parseDataHora(sc.nextLine());
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        manager.cadastrarEvento(new Event(nome, endereco, categoria, horario, descricao));
    }

    private static void listarEventosFuturos() {
        List<Event> eventos = manager.listarEventosFuturos();
        if (eventos.isEmpty()) System.out.println("Nenhum evento futuro.");
        else eventos.forEach(System.out::println);
    }

    private static void participarEvento() {
        User user = escolherUsuario();
        if (user == null) return;
        listarEventosFuturos();
        System.out.print("Nome do evento para participar: ");
        String nome = sc.nextLine();
        Event evento = manager.getEventos().stream()
            .filter(e -> e.getNome().equalsIgnoreCase(nome))
            .findFirst().orElse(null);
        if (evento != null) {
            manager.participarEvento(user, evento);
            System.out.println("Participação confirmada.");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    private static void cancelarParticipacao() {
        User user = escolherUsuario();
        if (user == null) return;
        Set<Event> eventos = manager.eventosUsuario(user);
        if (eventos.isEmpty()) {
            System.out.println("Você não está inscrito em nenhum evento.");
            return;
        }
        eventos.forEach(System.out::println);
        System.out.print("Nome do evento para cancelar: ");
        String nome = sc.nextLine();
        Event evento = eventos.stream()
            .filter(e -> e.getNome().equalsIgnoreCase(nome))
            .findFirst().orElse(null);
        if (evento != null) {
            manager.cancelarParticipacao(user, evento);
            System.out.println("Participação cancelada.");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    private static void listarEventosPassados() {
        List<Event> eventos = manager.listarEventosPassados();
        if (eventos.isEmpty()) System.out.println("Nenhum evento passado.");
        else eventos.forEach(System.out::println);
    }

    private static User escolherUsuario() {
        List<User> usuarios = manager.getUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return null;
        }
        System.out.println("Usuários:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i+1) + ". " + usuarios.get(i));
        }
        System.out.print("Escolha o número do usuário: ");
        int escolha = Integer.parseInt(sc.nextLine());
        if (escolha < 1 || escolha > usuarios.size()) {
            System.out.println("Escolha inválida.");
            return null;
        }
        return usuarios.get(escolha-1);
    }
}
