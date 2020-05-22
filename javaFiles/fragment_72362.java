public class Operation   {
    Environment e;
    public Operation(Environment e){
        this.e = e;
        e.incrementX();
        e.decrementY();
    }
    public void changeEnvironment()
    {   
       e.changeEnvironment() ;
    }
}