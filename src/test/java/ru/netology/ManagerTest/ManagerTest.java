package ru.netology.ManagerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {
    private TicketManager manager;
    private Ticket first = new Ticket(1, 2000, "DME", "SVX", 145);
    private Ticket second = new Ticket(2, 3000, "SVO", "SVX", 150);
    private Ticket third = new Ticket(3, 3500, "DME", "SVX", 120);
    private Ticket fourth = new Ticket(4, 5000, "SVO", "VVO", 1440);

    @BeforeEach
    public void setUp() {
        manager = new TicketManager(new TicketRepository());
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void showOptions() {
        Ticket[] expected = new Ticket[]{first, second, third, fourth};
        assertArrayEquals(expected, manager.showOptions());
    }

    @Test
    void mustSearchIfExists() {
        Ticket[] expected = new Ticket[]{first, third};
        assertArrayEquals(expected, manager.findAll("DME", "SVX"));
    }

    @Test
    void mustSearchIfNotExists() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAll("DME", "VVO"));
    }
}



