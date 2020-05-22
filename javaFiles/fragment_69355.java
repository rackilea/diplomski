class SuperTest {
    SuperTest() { whoAmI(SuperTest.class); }
    void whoAmI(Class c) { System.out.println(c.getName()); }
}
class Test extends SuperTest {
    Test() { whoAmI(Test.class); }        
}