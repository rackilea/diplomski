tester = tester.theTestExample();
    System.out.println(tester.getTestNumber());

public Example theTestExample(){
    Example myTester = new Example();
    MyTester.setTestNumber(4);
    System.out.println(MyTester.getTestNumber());
    return myTester;
}