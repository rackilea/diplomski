public void setDateExpired(String ticketType) {
   if (ticketType.equals("Gold")) {
        dateExpired = dateExpired + 2628000000L;
    } else if (ticketType.equals("Silver")) {
        dateExpired = dateExpired + 1209600000L;
    } else {
        dateExpired = dateExpired + 604800000L;
    }
}