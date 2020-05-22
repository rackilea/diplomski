public static void main(String[] args) throws Exception
{
    String[] data = { "a", "b", "c", "d", "e", "f","g" };
    LinkedBlockingQueue<String> lb = new LinkedBlockingQueue<>(Arrays.asList(data));

    new Thread(() -> 
    { 
        try
        {
            Thread.sleep(2000);
            lb.add("x");
            System.out.println("added");
            Thread.sleep(1000);
            lb.remove("e");
            System.out.println("removed");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        } 
    }).start();

    for (String s : lb)
    {
        System.out.println(s);
        Thread.sleep(1000);
    }
}