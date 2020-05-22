public static void inputFlight (Scanner input, Flight[] flight ,File fin ) throws IOException{
if (indexFlight<flight.length)  {
   flight[indexFlight]=new Flight();
   String flightCode=input.next();// This line takes ADD_FLIGHT instead of flight code SV221 
    flight[indexFlight].setflightCod(flightCode);
        String ctyfrom=input.next();//This line takes SV221 instead of Jeddah
    flight[indexFlight].setcityFrom(ctyfrom);
        String ctyto=input.next();//This line takes Jeddah instead of NewYork
    flight[indexFlight].setCityTo(ctyto);
             int total=input.nextInt();//This line takes NewYork instead of 30 thus InputMisMatchException occurs.
                  flight[indexFlight].setTotalSeats(total);
             double price=input.nextDouble();
                  flight[indexFlight].setprice(total);

indexFlight++;

}}