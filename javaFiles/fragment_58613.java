import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location
    implements Runnable
{

  private final int id;

  private final List<Integer> dependentLocationIds;

  private final Lock lock = new ReentrantLock();

  private boolean isUnlocked = true;

  public Location(int id, List<Integer> dependentLocationIds)
  {
    this.id = id;
    this.dependentLocationIds = dependentLocationIds;
    Collections.sort(dependentLocationIds);
  }

  public int getId()
  {
    return id;
  }

  public List<Integer> getDependentLocationIds()
  {
    return dependentLocationIds;
  }

  public boolean isUnlocked()
  {
    return isUnlocked;
  }

  public boolean blockLocation()
  {
    lock.lock();
    isUnlocked = false;
    System.out.printf("Location: %d occupied by: %s\n", this.getId(),
        Thread.currentThread().getName());
    return isUnlocked;
  }

  public boolean releaseLocation()
  {
    lock.unlock();
    isUnlocked = true;
    System.out.printf("Location: %d released by: %s\n", this.getId(),
        Thread.currentThread().getName());
    return isUnlocked;
  }

  public void occupy()
  {
    while (!LocationHelper.acquireLocks(this))
    {
      try
      {
        System.out.printf("Location: %d sleeping during occupy on: %s\n",
            this.getId(), Thread.currentThread().getName());
        Thread.sleep(1500);
      }
      catch (InterruptedException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    try
    {
      // below sleep added to track the progress slowly
      Thread.sleep(1000);

      System.out.printf("Location: %d doing something on: %s\n", this.getId(),
          Thread.currentThread().getName());
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
      LocationHelper.releaseLocks(this);
    }
  }

  public void leave()
  {
    try
    {
      // below sleep added to track the progress slowly
      Thread.sleep(1000);

      System.out.printf("Location: %d is attempting to leave on: %s\n",
          this.getId(), Thread.currentThread().getName());
      LocationHelper.releaseLocks(this);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    finally
    {
      LocationHelper.releaseLocks(this);
    }
  }

  public void run()
  {
    occupy();
    leave();
  }

  public static void main(String[] args)
  {
    List<Location> locations = LocationHelper.getLocations();

    for (Location location : locations)
    {
      // Each location runs in different threads here
      new Thread(location, "THREAD-" + location.getId()).start();
    }
  }
}