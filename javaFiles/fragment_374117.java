public class Printer implements Job{ // just add 'public'!
    public Printer(){
        System.out.println("created printer");
    }

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("hi" + context.getFireTime());
    }

}