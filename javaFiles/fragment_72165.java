class ASuperClass {
    protected int fieldInASuperClass;
    public final void addDeclaredFields(){
        Field[] fields = this.getClass().asSubclass(this.getClass()).getDeclaredFields();
        for(Field field : fields) {
            //edited this line for test purposes
            System.out.println(field.getName());
        }
    }
}

class ASubClass extends ASuperClass {
    private int fieldInASubClass;
}

class AnotherSubClass extends ASuperClass {
    private int fieldInAnotherSubClass;
    private int justAnotherFieldInAnotherSubClass;
}

public class AMainClass {
    public static void main(String[] args) {
        new ASuperClass().addDeclaredFields();
        System.out.println("--------------------------------------");
        new ASubClass().addDeclaredFields();
        System.out.println("--------------------------------------");
        new AnotherSubClass().addDeclaredFields();
    }
}