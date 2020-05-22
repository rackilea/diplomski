try {
        throw null;     // throws NullPointerException!
    } catch (Exception e) {
        int oops = 1/0; // throws ArithmeticException!
    } finally {
        System.out.println("Finally!"); // still gets executed!
    }
    System.out.println("What about me???"); // doesn't get executed!