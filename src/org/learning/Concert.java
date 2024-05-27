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
        this.hour = hour;
        this.price = price;
    }

    // Metodi

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
        this.hour = hour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN);
        return "Titolo: " + super.getTitle() + " | Data: " + getDate().format(formatter) + " | Ora: " + formattedHour() + " | Prezzo: " + formattedPrice();
    }
}
