for (CustomerEventDetails customerData : customerDetails) {
    liveTvEventDto = new EventDto();
    // Set member variables

    if (liveEvents.size() > 0) {
        System.out.println("Last Object: " + liveEvents.get(liveEvents.size() - 1));

        if (/* Logic for checking if the objects are NOT equal */)
            liveEvents.add(liveTvEventDto);
    } else {
        liveEvents.add(liveTvEventDto);
    }
}