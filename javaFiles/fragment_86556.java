public boolean cancelTicket(Flight f, Customer c) {
    Iterator<BookingDetails> bdIter = c.getBooking().iterator();

    if (!bdIter.hasNext())
        return false;

    while (bdIter.hasNext())
        if (bdIter.next().getFlight() == f)
            bdIter.remove();

    return true;
}