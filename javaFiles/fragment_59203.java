private static void moveOnePointOf(final PointArray pa)
{
    pa.setCapability(PointArray.ALLOW_COORDINATE_WRITE);
    Thread t = new Thread(new Runnable()
    {
        Point3f p = new Point3f();
        @Override
        public void run()
        {
            while (true)
            {
                pa.getCoordinate(0, p);
                p.x = (float)Math.sin(System.currentTimeMillis()/1000.0);;
                pa.setCoordinate(0, p);

                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
    });
    t.setDaemon(true);
    t.start();
}