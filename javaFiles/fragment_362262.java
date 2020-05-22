public static void inputFlight (Scanner input, Flight[] flight ,File fin ) throws IOException{
if (indexFlight<flight.length)  {
   String not_in_use=input.next()//**for moving input cursor to next (flight code)**
   flight[indexFlight]=new Flight();
   String flightCode=input.next();
    flight[indexFlight].setflightCod(flightCode);
        String ctyfrom=input.next();
    flight[indexFlight].setcityFrom(ctyfrom);
        String ctyto=input.next();
    flight[indexFlight].setCityTo(ctyto);
             int total=input.nextInt();
                  flight[indexFlight].setTotalSeats(total);
             double price=input.nextDouble();
                  flight[indexFlight].setprice(total);

indexFlight++;

}}