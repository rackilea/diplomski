public class ClassA {

    private Main main;
    Object obj = new Object;

    public void setMain(Main main) {
        this.main = main;
    }
    methodA() {  //called first
        System.out.println(obj); //you should see the same hash as in methodB
        obj.someFunction();
        main.someFunction();
    }
    methodB() {  //called second
        System.out.println(obj); //you should see the same hash as in methodA
        obj.someOtherFunction();
    }
}