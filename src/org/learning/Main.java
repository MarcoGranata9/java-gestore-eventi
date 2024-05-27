package org.learning;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Event evento = new Event("ciao", LocalDate.parse("2024-06-15"), 100);

        System.out.println(evento.getTitle());
        System.out.println(evento.getDate());

        evento.setDate(LocalDate.parse("2132-09-24"));
        evento.setTitle("Hello");

        evento.bookSeat(101);
        evento.cancelBookSeat(11);

        System.out.println(evento.getMaxSeat());
        System.out.println(evento.getReservedSeat());

        System.out.println(evento);
    }
}
