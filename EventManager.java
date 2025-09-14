package eventsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EventManager {
    private List<Event> events;
    private List<User> users;
    private Map<User, Set<Event>> participacoes;

    public EventManager() {
        events = Persistence.loadData("events.data");
        users = Persistence.loadData("users.data");
        participacoes = new HashMap<>();
    }

    public void salvar() {
        Persistence.saveData(events, "events.data");
        Persistence.saveData(users, "users.data");
    }

    public void cadastrarUsuario(User user) {
        users.add(user);
        salvar();
    }

    public void cadastrarEvento(Event event) {
        events.add(event);
        salvar();
    }

    public List<Event> listarEventosFuturos() {
        List<Event> futuros = new ArrayList<>(events);
        futuros.removeIf(e -> e.getHorario().isBefore(LocalDateTime.now()));
        futuros.sort(Comparator.comparing(Event::getHorario));
        return futuros;
    }

    public List<Event> listarEventosPassados() {
        List<Event> passados = new ArrayList<>();
        for (Event e : events) {
            if (e.getHorario().isBefore(LocalDateTime.now())) passados.add(e);
        }
        return passados;
    }

    public void participarEvento(User user, Event event) {
        participacoes.computeIfAbsent(user, k -> new HashSet<>()).add(event);
    }

    public void cancelarParticipacao(User user, Event event) {
        if (participacoes.containsKey(user)) participacoes.get(user).remove(event);
    }

    public Set<Event> eventosUsuario(User user) {
        return participacoes.getOrDefault(user, new HashSet<>());
    }

    public List<User> getUsuarios() { return users; }
    public List<Event> getEventos() { return events; }

    public static LocalDateTime parseDataHora(String input) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(input, fmt);
    }
}
