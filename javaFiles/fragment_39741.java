new Thread("PainterThread")
{
     public void run()
     {
          while (true)
          {
               try
               {
                    updateGraphics();
                    Thread.sleep(10);
               } catch (Exception e) {}
          }
     }
}.start();