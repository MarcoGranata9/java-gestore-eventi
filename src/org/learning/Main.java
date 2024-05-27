package org.learning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        Concert c = new Concert("titolo", LocalDate.parse("2024-12-12"), 100, LocalTime.parse("23:30"), new BigDecimal("2.333333333333"));

        System.out.println(c);

        Event event = null;
        while (event == null) {
            System.out.println("Inserisci il titolo dell' evento");
            String title = scanner.nextLine();
            System.out.println("Inserisci la data dell' evento giorno/mese/anno" );
            String date = scanner.nextLine();
            System.out.println("Inserisci il numero di posti dell' evento");
            int maxCap = 0;
            maxCap = getMaxCap(scanner);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN);
            try {
                event = new Event(title, LocalDate.parse(date, formatter), maxCap);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("Il formato della data deve essere giorno/mese/anno");
            }
        }

        while (!exit) {
            System.out.println("Esci = e");
            System.out.println("Prenota = p");
            System.out.println("Disdici = d");

            String choice = scanner.nextLine();
            switch (choice) {
                case "e":
                    exit = true;
                    printInfo(event);
                    break;
                case "p":
                    System.out.println("Quanti posti vuoi prenotare?");
                    int seatsToBook = Integer.parseInt(scanner.nextLine());
                    try {
                        event.bookSeat(seatsToBook);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    printInfo(event);
                    break;
                case "d":
                    System.out.println("Quanti posti vuoi disdire?");
                    int seatsToCancel = Integer.parseInt(scanner.nextLine());
                    try {
                        event.cancelBookSeat(seatsToCancel);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    printInfo(event);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }

    private static int getMaxCap(Scanner scanner) {
        int maxCap;
        while (true) {
            try {
                maxCap = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("La capacità massima deve essere un numero intero");
            }
        }
        return maxCap;
    }

    private static void printInfo(Event event) {
        System.out.println("----------------------------------");
        System.out.println(event.getTitle());
        System.out.println("Posti riservati: " + event.getReservedSeat());
        System.out.println("Posti disponibili " + (event.getMaxSeat() - event.getReservedSeat()));
        System.out.println("----------------------------------");

    }
}
