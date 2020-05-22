public String searchName(String guest)
{
    for (Booking s : bookings)
    {
        if (s.getGuest().equals(guest))
        return guest + " is in room " + s.getRoomId() + "\n"; 
    }
    return guest + " is not booking in at the hostel";
}