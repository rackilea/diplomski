//Several classes doing each one its thing.
public class Task1 implements Runnable { ... }
public class Task2 implements Runnable { ... }
public class Task3 implements Runnable { ... }

//Collection with runnable instances
List<Runnable> tasks = new ArrayList<Runnable>();

//A producer would have populated the list with some instances depending on some conditions
if(cond1) tasks.add(new Task1());
if(cond2) tasks.add(new Task2());
if(cond3) tasks.add(new Task3());

//Now we execute tasks without caring what do they do.
ExecutorService executor = Executors.newFixedThreadPool(1);
for(Runnable r : tasks){
    executor.execute(r);
}