package org.learning.bonus;

import org.learning.Event;

import java.time.LocalDate;

public class MainList {
    public static void main(String[] args) {
        EventProgram e = new EventProgram("Programma");
        e.addEvent(new Event("Pippo", LocalDate.parse("2024-10-11"), 100));
        e.addEvent(new Event("Pluto", LocalDate.parse("2024-07-16"), 200));
        e.addEvent(new Event("Paperino", LocalDate.parse("2024-08-12"), 200));

        System.out.println(e.programLength());


        System.out.println(e.printProgram());
        e.getEventsPerDate("2024-10-11");
        System.out.println(e.printProgram());
        e.emptyList();
        System.out.println(e.printProgram());
    }
}
