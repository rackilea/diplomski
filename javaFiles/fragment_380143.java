interface Checkable {
    public void check();
}

public class Foo implements Checkable {
    public static void main(String[] args){
        try {
            Class currentClass = new Object() { }.getClass().getEnclosingClass();
            Checkable instance = (Checkable) currentClass.newInstance();
            instance.check();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void check() {
        System.out.println("Check succesful");
    }
}