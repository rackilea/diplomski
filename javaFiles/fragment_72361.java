public class Environment {
    int x = 0;
    int y = 0;
    Operation op ;

    public Environment(){
         op=new Operation(this);

    }

    public void changeEnvironment() {}
    public void incrementX(){}
    public void incrementY() {}
}