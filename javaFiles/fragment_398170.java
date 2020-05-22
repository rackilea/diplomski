public class RunnableClass {

    private static A object;

    @Autowired
    public void setA(A object){
        RunnableClass.object = object;
    }

    public static void main(String[] args) 
    {
        object.printUsername();
    }

}