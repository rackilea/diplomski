public interface Animal {
    public void accept(AnimalVisitor v); 
}

public class Dog extends Animal {
    public void accept(AnimalVisitor v) {
        v.visit(this);
    }
}

public class Cat extends Animal {
    public void accdept(AnimalVistior v) {
        v.visit(this);
    }   
}

public interface AnimalVisitor {
    public void visit(Dog d);
    public void visit(Cat c);
}

public class PrintAnimal implements AnimalVisitor {

    public void visit(Dog d) {
        System.out.println("Dog");
    }

    public void visit(Cat c) {
        System.out.println("Cat");
    }

}