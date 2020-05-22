class Parent {
    Parent() {
        System.out.println("Parent()");
    }
    Parent(String name) {
        System.out.println("Parent(String): " + name);
    }
}

class Child extends Parent {
    Child() {
        //calls "super()" implicitly as we don't call a constructor of Parent ourselfs
        System.out.println("Child()");
    }

    Child(String name) {
        super(name); //we explicitly call a super-constructor
        System.out.println("Child(String): " + name);
    }
}

new Child();
new Child("A Name");