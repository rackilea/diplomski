public void showBarChanging(final Player p)
  {
    getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {

      private static int count=1;
      public void run()
      {
           if (count>7) count=1;

           String string = DCBar.this.getConfig().getString(Integer.toString(count++));
           string = string.replaceAll("&", "§");

           BarAPI.setMessage(p, string, 5);   

      }
    }, 0L, 100L);
  }