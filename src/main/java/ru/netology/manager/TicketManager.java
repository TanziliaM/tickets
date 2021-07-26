package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketManager {
    TicketRepository repository;

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getDeparture().equalsIgnoreCase(from) && ticket.getArrival().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] showOptions() {
        Ticket[] result = repository.getAll();
        Arrays.sort(result);
        return result;
    }
}
