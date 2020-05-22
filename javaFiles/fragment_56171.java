public static void otherMain(String[] args) {  
    Main.main(args);
}

public static void main(String[] args) {  

    ...

    StackTraceElement[] elems = Thread.currentThread().getStackTrace();
    //for (StackTraceElement elem : elems) {
    //    System.out.printf("%s%n", elem.getClassName());
    //}
    if (elems.length > 2) { // [0] Thread [1] main
        System.setProperty("main_result","0");
    }
}