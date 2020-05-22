public class SimpleBean {
    private int counter;
    public String sayHello() {  
        return Integer.toString(counter++);
    }  
}