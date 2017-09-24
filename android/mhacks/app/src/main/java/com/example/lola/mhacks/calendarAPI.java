package com.example.lola.mhacks;

public class calendarAPI {

    private static String eventTitle, location, date;

    public calendarAPI(String event, String location, String date) {
        this.eventTitle = event;
        this.location = location;
        this.date = date;
    }

    public static void addAttachment(Calendar calendarService, Event event){

        calendarService.events().patch(event.calendarId, event.eventId, event)
                .setSupportsAttachments(true)
                .execute();
    }

    public static void main(String[] args) {

        EventDateTime start = new EventDateTime().setDateTime(date);
        Event event = new Event()
                .setTitle(eventTitle)
                .setLocation(location)
                .setStart(start);
        addAttachment(calendarService, driveService, calendarId,
                String eventId, String fileId);
    }
}
