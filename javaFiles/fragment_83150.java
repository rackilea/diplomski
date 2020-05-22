public interface ReservationSystem {
  public int createNewBooking();
  public int reserveSeatsOnFlight(int bookingId, int seats);
  public int chooseMealPreference(int bookingId, ...)
  ...
}