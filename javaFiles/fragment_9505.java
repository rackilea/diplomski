public class Specific extends Generic {
    boolean initialized = false;
    public Specific(){
        super();
        initialized = true;
    }

    @Override
    protected void doStuff(){
        super.doStuff();
        if (!initialized) return;
        System.out.println("Specific");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Specific specific = new Specific();
    }
}