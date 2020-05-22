@FunctionalInterface
public interface Plan {
    public boolean execute();
}

public static boolean tryAll(List<Plan> lst) {
    for(Plan p : lst) {
        if(p.execute()) return true;
    }
    return false; //All plans failed
}