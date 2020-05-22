package x;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import lombok.Data;

@Singleton
@Startup
public class CounterBean
{
  private int hitCount;

  public int getHitCount()
  {
    return hitCount;
  }

  public void incHitCount()
  {
    hitCount++;
  }

  public CounterBean()
  {}
}