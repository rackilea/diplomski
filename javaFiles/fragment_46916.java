public class MyJob extends Job {
    public void doJob() throws Exception {
        Printer printer = Spring.getBeanOfType(Printer.class);
        printer.print();
    }
}