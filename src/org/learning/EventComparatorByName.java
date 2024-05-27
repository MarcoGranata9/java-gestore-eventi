package org.learning;

import java.util.Comparator;

public class EventComparatorByName implements Comparator<Event> {
    @Override
    public int compare(Event o1, Event o2) {
        if (o1.getDate() == null || o2.getDate() == null) {
            return 0;
        }
        return o1.getDate().compareTo(o2.getDate());
    }
}
