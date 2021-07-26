package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket first = new Ticket(1, 2000, "DME", "SVX", 145);
    private Ticket second = new Ticket(2,3000, "SVO", "SVX", 150);
    private Ticket third = new Ticket(3,3500,"VKO", "SVX", 120);
    private Ticket fourth = new Ticket(4, 5000, "SVO", "VVO", 1440);


    @Test
    void mustSave() {
        repository.save(first);
        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNotEmpty() {
        repository.save(first);
        repository.save(second);
        Ticket[] expected = new Ticket[]{first, second};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

}



