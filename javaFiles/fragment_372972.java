//define a callable which will be executed asynchronously in a thread.
static class MyString implements Callable<String> {
    Scanner scanner;
    public MyString(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Enter now");
        return scanner.next();
    }
}

public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    ExecutorService executor = Executors.newFixedThreadPool(1);//just one thread
    MyString str = new MyString(userInput);
    Future<String> future = executor.submit(str);//it will ask user for input asynchronously and will return immediately future object which will hold string that user enters.
    try {
        String string = future.get(1, TimeUnit.SECONDS);//get user input within a second else you will get time out exception.
        System.out.println(string);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
        e.printStackTrace();//if user failed to enter within a second..
    }
}