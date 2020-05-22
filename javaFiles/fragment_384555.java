public void someFunction() {
        try {
            function1();    
            function2();
                ...      
        } catch (Func1Exception e) {
            System.out.println("Function 1 failed!");
            return;
        }
        catch (Func2xception e) {
            System.out.println("Function 2 failed!");
            return;
        }    
    }
    ...
}