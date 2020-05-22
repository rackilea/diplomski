public class Nestedinterface {
     public interface NestI{
         void show();
     }
}

public class NestedinterfaceImpl implements NestI {
    public static void main(String a[]) {
        NestI n = new NestedinterfaceImpl();
        n.show();
    }
    public void show() {
        // TODO Auto-generated method stub
        System.out.println("Hello world");    
    }
}