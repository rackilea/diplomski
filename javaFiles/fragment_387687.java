import java.util.ArrayList;
import java.util.List;

public class HotelStuff {

  private static class Hotel{/* does whatever ...*/}

  private enum SearchMethod{
    HOTELCODE,
    DESTINATIONCODE,
    GEOCODE
  }

  private interface Providable{
    List<Hotel> findAvailHotels(SearchMethod method, List<String> codes); 
  }

  private static class Provider1 implements Providable{
    @Override
    public List<Hotel> findAvailHotels(SearchMethod method, List<String> codes) {
        // TODO create the list ...
        return null;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<Providable> providers = new ArrayList<Providable>();
    providers.add(new Provider1());
    // providers.add(new Provider2 .. and so on     
    List<String> codes = Arrays.asList("123","456");
    SearchMethod method = SearchMethod.GEOCODE;
    List<Hotel> availableHotels = findAvailHotels(providers, method, codes);
  }

  public static List<Hotel> findAvailHotels(List<Providable> providers, SearchMethod method, List<String> codes) {
    List<Hotel> result = new ArrayList<Hotel>();
    List<Hotel> partResult;
    for(Providable provider: providers) {
        partResult = provider.findAvailHotels(method, codes);
        result.addAll(partResult);
    }
    return result;
  }

}