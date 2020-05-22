class TupleConverter implements MapFunction<TaxiRide, Tuple9<Long, Boolean, DateTime, DateTime, Float, Float, Float, Float, Float, Short>> {

  public Tuple9<Long, Boolean, DateTime, DateTime, Float, Float, Float, Float, Float, Short> map(TaxiRide ride) {
     return Tuple9.of(ride.rideId, ride.isStart, ...);
  }
}