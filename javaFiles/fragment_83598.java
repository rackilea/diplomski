private static final abstractTester[] testerClasses={
    new Tester1()
};

intent =new Intent(this,testerClasses[0].getClass());
startActivity(intent);