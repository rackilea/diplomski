public class HeapSize {
    public static final void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total currently: " + rt.totalMemory());
        System.out.println("Max:             " + rt.maxMemory());
        System.exit(0);
    }
}