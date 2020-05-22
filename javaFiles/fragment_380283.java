public static void main(String[] args) throws InterruptedException
{
    ExecutorService executor = Executors.newFixedThreadPool(3);
    for(int i = 0 ; i < 5 ; i++)
    {
       // add 5 instances of CSVParser
       executor.execute(new CSVParser());
    }

}