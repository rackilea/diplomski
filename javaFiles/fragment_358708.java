class DatedTravelledPlaces
{
   private Date date;
   private TravelledPlaces places;

    DatedTravelledPlaces(Date date, String from, String to)
    {
      //construction
    }

    @Override
    public int hashCode() {
      //same as what you did with TravelledPlaces 
    }

    @Override
    public boolean equals(Object obj) {
      //same as what you did with TravelledPlaces 
    }
}

public class TimeConsumedCache {
    private Map<DatedTravelledPlaces, double> timeCache;


     TimeConsumedCache()
     {
       int dbsize = computeDBSize();
       timeCache = new HashMap<DatedTravelledPlaces, double>(dbsize );
     }

}