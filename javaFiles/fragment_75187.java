public class Benchmark
{
  public static void main(String... pArgs)
  {
    // prepare all data as much as possible.
    // we don't want to do this while the clock is running.
    Class[] classes = {Object.class, Integer.class, String.class, Short.class, Long.class, Double.class,
                       Float.class, Boolean.class, Character.class, Byte.class};
    int cycles = 1000000;
    String[] classNames = new String[cycles];
    for (int i = 0; i < cycles; i++) 
    {
      classNames[i] = classes[i % classes.length].getName();
    }

    // THERE ARE 2 IMPLEMENTATIONS - CLASSIC vs CACHING
    Implementation impl = new Caching();   // or Classic();

    // Start the clocks !
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < cycles; i++)
    {
      impl.doStuff(classNames[i]);
    }
    long endTime = System.currentTimeMillis();

    // calculate and display result
    long totalTime = endTime - startTime;
    System.out.println(totalTime);
  }
}