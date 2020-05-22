public void someFunction() {
    try {
        function1();    
        function2();
            ...      
    } catch (Func1Exception e) {
        System.out.println("Function 1 failed!");
    }
    catch (Func2xception e) {
        System.out.println("Function 2 failed!");
    }    
}