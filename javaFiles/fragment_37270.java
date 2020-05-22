@FunctionalInterface
public interface Plan {
    public void execute() throws Exception;
}

public static boolean tryAll(List<Plan> lst) {
    for(Plan p : lst) {
        try {
            p.execute();
            return true; //If we reach this line, p succeeded
        } catch (Exception e) {
            //This plan failed
        }
    }
    return false; //All plans failed
}