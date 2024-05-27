package org.learning;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Event {
    // Attributi
    private final int MAX_CAPACITY;
    private String title;
    private LocalDate date;
    private int reservedSeat = 0;

    // Costruttore
    public Event(String title, LocalDate date, int MAX_CAPACITY) throws IllegalArgumentException{
        this.title = title;
        this.date = checkDate(date);
        this.MAX_CAPACITY = checkMaxSeat(MAX_CAPACITY);
    }

    // Metodi
    private int checkMaxSeat (int MAX_CAPACITY) throws IllegalArgumentException{
        if (MAX_CAPACITY <= 0) {
            throw new IllegalArgumentException("Il numero di posti deve essere positivo " + "Numero inserito" + MAX_CAPACITY);
        }
        return MAX_CAPACITY;
    }

    private LocalDate checkDate (LocalDate date) throws IllegalArgumentException{
        if (date == null || date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data non valida: " + date);
        }
        return date;
    }
    // Prenota posto
    public void bookSeat(int seatsToBook) throws IllegalArgumentException{
        if (reservedSeat + seatsToBook > MAX_CAPACITY || date.isBefore(LocalDate.now())) {
            int availableSeats = MAX_CAPACITY - reservedSeat;
            throw new IllegalArgumentException("Posti disponibili: " + availableSeats + ", Posti inseriti " + seatsToBook);
        }
        reservedSeat += seatsToBook;
    }
    // Disdici posto
    public void cancelBookSeat(int seatsToCancel) {
        if (reservedSeat - seatsToCancel < 0 || date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Posti riservati: " + reservedSeat + " Posti inseriti " + seatsToCancel);
        }
        reservedSeat -= seatsToCancel;
    }
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) throws IllegalArgumentException{
        this.date = checkDate(date);
    }
    // Getters
    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMaxSeat() {
        return MAX_CAPACITY;
    }

    public int getReservedSeat() {
        return reservedSeat;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN);
        return "Event {" + "\n" +
                "title: " + title + "\n" +
                "date: " + date.format(formatter) + "\n" +
        "}";
    }
}

