import static java.util.concurrent.CompletableFuture.*;

...

Executor e = Executors.newFixedThreadPool (100);
List<PrgState> = prgList.stream ()
                        .map (p -> supplyAsync ( () -> p.oneStep (), e))
                        .reduce (new ArrayList<PrgState> (), (a, f) -> {
  try {
    a.add (f.get ());
    return a;
  } catch (Exception e1) {
    throw new RuntimeException (e1);
  }
}, (a1, a2) -> {
  ArrayList<PrgState> a = new ArrayList<> ();
  a.addAll (a1);
  a.addAll (a2);
  return a;
});