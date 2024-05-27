package org.learning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concert extends Event{
    LocalTime hour;
    BigDecimal price;

    public Concert(String title, LocalDate date, int MAX_CAPACITY, LocalTime hour, BigDecimal price) throws IllegalArgumentException {
        super(title, date, MAX_CAPACITY);
        this.hour = checkHour(hour);
        this.price = checkPrice(price);
    }

    // Metodi
    private LocalTime checkHour(LocalTime hour) throws IllegalArgumentException{
        if (hour == null || hour.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("L'orario inserito non è valido");
        }
        return hour;
    }

    private BigDecimal checkPrice(BigDecimal price) throws IllegalArgumentException{
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Il prezzo non può essere negativo");
        }
        return price;
    }

    public String formattedPrice() {
        return String.format("%.2f€", price);
    }

    public String formattedHour() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        return hour.format(format);
    }

    // Getters / Setters
    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = checkHour(hour);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = checkPrice(price);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN);
        return "Titolo: " + super.getTitle() + " | Data: " + getDate().format(formatter) + " | Ora: " + formattedHour() + " | Prezzo: " + formattedPrice();
    }
}
