ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

void start(final Connection conn)
{
  executor.scheduleWithFixedDelay(new Runnable(){ public void run(){ try { poll(conn); } catch (Exception e) { e.printStackTrace(); } } }, 0, 1, TimeUnit.HOURS);
}

private void poll(Connection conn) throws SQLException
{
  final ResultSet results = conn.createStatement().executeQuery("SELECT song, playtime FROM schedule WHERE playtime > GETDATE() AND playtime < GETDATE() + 1 HOUR");
  while (results.next())
  {
    final String song = results.getString("song");
    final Time time = results.getTime("playtime");

    executor.schedule(new Runnable(){ public void run() { play(song); } }, time.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }
}