A a1 = new A();//Object of A in heap which is referred by reference of A
        B b1 = new B();//Object of B in heap which is referred by reference of B
        a1 = b1; // ***Line 1*** Here super type(a1) is referring to subtype b1. So actual object is that of class B.
        System.out.println("After referencing!");
        a1.method();//method from actual object is called ie b1
        a1.method2();//same

        A a2 = new B(); // ***Line 2*** again object created in heap is of type B but its referred by super type A
        a2.method();//and hence,method called is from B class not from class A
        a2.method2();