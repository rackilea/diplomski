public static void processBirthdaysFor(Contact<Birthday> birthdayContact, DateTime start, DateTime end) {
    Set<Birthday> birthdays = personalContact.getEventsWithinPeriod(start, end);
    for (Birthday birthday : birthdays) {
        // Do stuff with birthday
    }
}