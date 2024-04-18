import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Moscow", "Sochi", 15_000, 17, 23); //5
    Ticket ticket2 = new Ticket("Saint-Petersburg", "Moscow", 8_000, 9, 12); //3

    Ticket ticket3 = new Ticket("Moscow", "Sochi", 25_000, 12, 14); //2
    Ticket ticket4 = new Ticket("Ufa", "Omsk", 3_000, 9, 10); //1
    Ticket ticket5 = new Ticket("Tumen", "Surgut", 12_000, 6, 8); //2

    @Test
    public void shouldCompareTwoTicketsAndSortByPrice() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] actual = {ticket1, ticket2};

        Arrays.sort(actual);

        Ticket[] expected = {ticket2, ticket1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneTicket() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Tumen", "Surgut");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchCityAndSortByPrice() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Moscow", "Sochi");
        Ticket[] expected = {ticket1, ticket3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchNoneTicket() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Moscow", "Tula");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchTicketCityFromCityToAndSortTimeFly() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket1};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Sochi", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicketCityFromCityToAndSortTimeFly() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.searchAndSortBy("Tumen", "Surgut", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoneTicketCityFromCityToAndSortTimeFly() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Tumen", "Adler", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
