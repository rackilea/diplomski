List<Future<String>> futures = new ArrayList<Future<String>>();
for(int i = 1; i < number; i++){
    B b = new B(list.get(i - 1));
    // submit the job b add the resulting Future to the list
    futures.add(pool.submit(b));
}
// all of the jobs are submitted now
StringBuilder sb = new StringBuilder();
for (Future<String> future : futures) {
   // now join with each of the jobs in turn and get their return value
   sb.append(future.get());
}
System.out.println(sb.toString());

// you should implement Callable _not_ extend thread
public class B implements Callable<String> {
    public String call(){
        return "some string";
    }
}