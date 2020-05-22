public static void main (String[] args) {
    // a few classes
    Parent parent = new Parent();
    ChildOne childOne = new ChildOne();
    ChildOne childOneCopy = new childOne();
    ChildTwo childTwo = new childTwo();

    // take a peek at the values
    System.out.println(parent.myStaticVariable):
    System,out.println(childOne.myStaticVariable);
    System,out.println(childTwo.myStaticVariable);

    // let's change the value
    parent.myStaticVariable = 66;
    System.out.println(parent.myStaticVariable):
    System,out.println(childOne.myStaticVariable);
    System,out.println(childTwo.myStaticVariable);

    // and the two copies of ChildOne?
    childOne.myStaticVariable = 123;
    System,out.println(childOneCopy.myStaticVariable);
    childOneCopy.myStaticVariable = 456;
    System,out.println(childOne.myStaticVariable);
}