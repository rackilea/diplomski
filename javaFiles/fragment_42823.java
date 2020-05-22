class MyClass { }

public class Demo {

    static MyClass obj = new MyClass() { 
        { 
            System.out.println("static field: " + this.getClass().getName());
        }
    };

    MyClass obj2 = new MyClass() { 
        { 
            System.out.println("instance field: " + this.getClass().getName());
        }
    };    

    public static void main(String[] args) {
        Demo obj4 = new Demo();

        MyClass obj3 = new MyClass() { 
            { 
                System.out.println("local variable: " + this.getClass().getName());
            }
        };    

    }
}