public void someFunction() {
    try {
        function1();    
        function2();
            ...      
    } 
    catch (Func1Exception | Func2xception e) {
        System.out.println("Function 1 or 2 failed!");
    }
}