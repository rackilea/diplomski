Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credentials)
        .setApplicationName("applicationName").build();

    // Create a new calendar
    com.google.api.services.calendar.model.Calendar calendar = new Calendar();
    calendar.setSummary("calendarSummary");
    calendar.setTimeZone("America/Los_Angeles");

    // Insert the new calendar
    Calendar createdCalendar = service.calendars().insert(calendar).execute();

    System.out.println(createdCalendar.getId());