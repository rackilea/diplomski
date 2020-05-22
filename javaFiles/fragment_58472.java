try {
        demo();
    }
    catch(ArithmeticException e) {
        //display top_level exception
        System.out.println("Cautch : " + e);
        System.out.println("Main Cause : " + e.getCause());
    }