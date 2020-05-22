if (bookings == null)
{
     bookings= new HashMap<Integer, Booking>();
     identificator = 1;
} else if (bookings.isEmpty())
{
     identificator = 1;
}
else
{
     identificator = Collections.max(bookings.keySet()) + 1;
}