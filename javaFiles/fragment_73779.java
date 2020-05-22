public class GrigliaImpl implements Griglia {

private static GrigliaImpl instance;

private GrigliaImpl() {
}

public static GrigliaImpl getInstance() {
if (instance == null) {
instance = GrigliaImpl();
}
return instance;
}

public GrigliaImpl doSomething() {
// do something
return this;
}

}