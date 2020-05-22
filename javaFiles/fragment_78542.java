import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ImageWritingMain
{
  public static void main(String[] args) throws Exception
  {
    // a queue
    final BlockingQueue<BufferedImage> queue = 
        new LinkedBlockingQueue<BufferedImage>();

    // schedule a thread to take 20 images per second and put them in 
    // the queue
    int fps = 20;
    final ScreenShotRecorder recorder = 
        new ScreenShotRecorder(new Robot(), queue);
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(recorder, 0, (1000L/fps));

    // make a directory to hold the screenshot images
    String id = new Date().toString().replace(' ', '-').replace(':', '-');
    File imageDir = new File("images-" + id);
    imageDir.mkdirs();

    // start 10 threads, and each thread reads from the queue and 
    // writes the image to a file
    int nWriterThreads = 10;
    ExecutorService threadPool = Executors.newFixedThreadPool(nWriterThreads);
    for (int i = 0; i < nWriterThreads; i++)
    {
      ImageWriter task = new ImageWriter(queue, imageDir);
      threadPool.submit(task);
    }
    System.out.println("Started all threads ..");

    // wait as long as you want the program to run (1 minute, for example) ...
    Thread.sleep(60 * 1000L);
    // .. and shutdown the threads
    System.out.println("Shutting down all threads");
    threadPool.shutdownNow();
    timer.cancel();

    if (! queue.isEmpty())
    {
      System.out.println("Writing " + queue.size() + " remaining images");
      // write the remaining images to disk in the main thread
      ImageWriter writer = new ImageWriter(queue, imageDir);
      BufferedImage img = null;
      while ((img = queue.poll()) != null)
      {
        writer.writeImageToFile(img);
      }
    }
  }
}

class ScreenShotRecorder extends TimerTask
{
  private static final Rectangle screenRect = 
      new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
  private static final AtomicInteger counter = new AtomicInteger();
  private final Robot robot;
  private final BlockingQueue<BufferedImage> imageQueue;

  ScreenShotRecorder(Robot robot, BlockingQueue<BufferedImage> imageQueue)
  {
    this.robot = robot;
    this.imageQueue = imageQueue;
  }

  @Override
  public void run()
  {
    try
    {
      BufferedImage image = robot.createScreenCapture(screenRect);
      imageQueue.put(image);
      System.out.println(Thread.currentThread() + 
          ": Took screenshot #" + counter.incrementAndGet());
    }
    catch (InterruptedException e)
    {
      System.out.println("Finishing execution of " + Thread.currentThread());
      return;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}

class ImageWriter implements Runnable
{
  private static final AtomicInteger counter = new AtomicInteger();
  private final BlockingQueue<BufferedImage> imageQueue;
  private final File dir;

  ImageWriter(BlockingQueue<BufferedImage> imageQueue, File dir)
  {
    this.imageQueue = imageQueue;
    this.dir = dir;
  }

  @Override
  public void run()
  {
    while (true)
    {
      try
      {
        BufferedImage image = imageQueue.take();
        writeImageToFile(image);
      }
      catch (InterruptedException e)
      {
        System.out.println("Finishing execution of " + Thread.currentThread());
        return;
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  public void writeImageToFile(BufferedImage image) throws IOException
  {
    File file = new File(dir, "screenshot-" + counter.incrementAndGet());
    ImageIO.write(image, "JPG", file);
    System.out.println(Thread.currentThread() + 
        ": Wrote " + file.getCanonicalPath());
  }
}