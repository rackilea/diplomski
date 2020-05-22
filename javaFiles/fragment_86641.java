public class MiddleStage implements RecordHandler {

private RecordHandler next;
private ExecutorService executor = Executors.newFixedThreadPool(5);
private Queue<String> inbound = new LinkedList<String>();
Collection<Callable<String>> tasks = new ArrayList<Callable<String>>();

@Override
public void setNext(RecordHandler handler) {
    if (this.next == null) {
        this.next = handler;
    } else {
        this.next.setNext(handler);
    }
}

@Override
public void handleRequest(String record) {
    System.out.println("Adding new record to Queue : " + record);
    inbound.add(record);
    System.out.println("Queue Size : " + inbound.size());

    if (inbound.size() >= 10)
    {
        System.out.println("Processing the batch.");

        for (int i = 0; i < 10; i++){
            tasks.add(new MiddleWorker(inbound.poll()));
        }

        System.out.println("Processing @ Middle Stage. " + record);
        List <Future<String>> results = null;
        try {
            results = executor.invokeAll(tasks, 60, TimeUnit.SECONDS);
            tasks.clear();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (Future<String> f : results) {
              try {
                String answer = f.get();
                System.out.println("Outbound : " + answer);
                if (next != null) {
                    next.handleRequest(answer);
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
        results.clear();
    }
}
}