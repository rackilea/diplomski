public boolean overlapsWithExisting(Booking booking) {
    final Date early = booking.getStart();
    final Date late = booking.getEnd();
    for(Booking existing : existingBookings) {
        if(!(early.isAfter(existing.getEnd()) || late.isBefore(existing.getStart()))
            return true;
    }
    return false;
}