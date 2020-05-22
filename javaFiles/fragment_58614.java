import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LocationHelper
{
  private static List<Location> holdsLocks = new ArrayList<Location>();

  private static final List<Location> locations = new ArrayList<>();

  private static int printLocks = 0;

  static
  {
    locations.add(new Location(1, Arrays.asList(1, 2, 3, 4, 5)));
    locations.add(new Location(2, Arrays.asList(1, 2, 3, 4)));
    locations.add(new Location(3, Arrays.asList(1, 2, 3, 4)));
    locations.add(new Location(4, Arrays.asList(3, 4, 5)));
    locations.add(new Location(5, Arrays.asList(1, 2, 3, 4, 5)));
  }

  public static List<Location> getLocations()
  {
    return locations;
  }

  public static Location getLocation(int id)
  {
    return locations.stream().filter(l -> l.getId() == id).findFirst()
        .orElse(null);
  }

  public static synchronized boolean acquireLocks(Location location)
  {
    if (printLocks % 5 == 0)
    {
      locations.stream()
          .forEach(l -> System.out.printf("Location: %d status: %s\n",
              l.getId(), String.valueOf(l.isUnlocked())));
    }
    List<Location> required = location.getDependentLocationIds().stream()
        .map(LocationHelper::getLocation).collect(Collectors.toList());
    // If not available fail to lock.
    if (required.stream().filter(l -> !l.isUnlocked()).count() > 0L)
    {
      return false;
    }
    else
    {
      try
      {
        required.stream().forEach(Location::blockLocation);
        holdsLocks.add(location);
        return true;
      }
      catch (Exception e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
        required.stream().forEach(Location::releaseLocation);
        return false;
      }
    }
  }

  public static boolean releaseLocks(Location location)
  {
    if (!holdsLocks.contains(location))
    {
      return false;
    }
    else
    {
      List<Location> required = location.getDependentLocationIds().stream()
          .map(LocationHelper::getLocation).collect(Collectors.toList());

      try
      {
        required.stream().forEach(Location::releaseLocation);
        holdsLocks.remove(location);
        return true;
      }
      catch (Exception e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
      }
    }
  }
}