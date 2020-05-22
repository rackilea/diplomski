ArrayList<B> classB = new ArrayList<B>();
public static void main(String[] args) {
    // instantiate the objects
    A myClassA = new A();
    B myClassB = new B();
    C myClassC1 = new C();
    C myClassC2 = new C();
    // set the values
    myClassC1.setA(1);
    myClassC1.setB(10);
    myClassC2.setA(2);
    myClassC2.setB(20);
    myClassB.setX(3);
    myClassB.setY(30);
    // create the lists
    List<C> myListC = new ArrayList<C>();
    myListC.add(myClassC1);
    myListC.add(myClassC2);
    // set the lists
    myClassB.setObjC(myListC);
    myClassA.classB.add(myClassB);// better use a getter/setter
    // iterate the list
    for (B auxClassB : myClassA.classB) {
        System.out.println("X:" + auxClassB.getX() + " Y:"
                + auxClassB.getY());
        for (C auxClassC : auxClassB.getObjC()) {
            System.out.println("A: "+  auxClassC.a + " B: "+ auxClassC.getB());
        }
    }
}