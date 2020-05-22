private HashMap<String, Object> locks = new HashMap<String, Object>();
private final Object hashmapLock = new Object();
public void handleShortCode(String shortcode,String message,String from)
{
    Object lock = null;
    synchronized(hashmapLock){
      lock = locks.get(shortcode);
      if (lock == null)
      {
          locks.put(shortcode, lock = new Object());
      }
    }
    synchronized (lock)
    {
        System.out.println("Handling shortcode:" + shortcode);
        // processing
        System.out.println("Successfully handled shortcode:" + shortcode + " ......");
    }
}