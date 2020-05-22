synchronized static void add()
    {
        left++;
    }

  synchronized static int remove()
    {
        return --left;
    }

  synchronized static void print(long count, String name)
    {
        System.out.printf("%s %10d left: %3d%n", name, count, remove());
    }

  public void run()
    {
        ...
        print(count,name);
    }