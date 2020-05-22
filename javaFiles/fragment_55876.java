final AtomicInteger total = new AtomicInteger(0);
...
    Runnable r = new WordCount(args[i], total);
...
// join loop
// no need to total it up since each thread would be adding to the total directly
System.out.println(total);