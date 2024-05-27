package org.learning.bonus;

import org.learning.Event;
import org.learning.EventComparatorByName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EventProgram {
    private String title;
    private List<Event> events;

    public EventProgram(String title) {
        this.title = title;
        this.events = new ArrayList<Event>();
    }

    // Metodi

    public void addEvent(Event event) {
        events.add(event);
    }

    public int programLength() {
        return events.size();
    }

    public void emptyList() {
        events.clear();
    }

    public String printProgram() {
        events.sort(new EventComparatorByName());
        String res = "Titolo Programma: " + title + "\n";
        for (Event e : events) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN);
            res += e.getDate().format(formatter) + " - ";
            res += e.getTitle() + "\n";
        }
        return res;
    }

    public void getEventsPerDate(String date) {
        events.removeIf(e -> (!e.getDate().equals(LocalDate.parse(date))));
    }
}
