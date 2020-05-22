class Example {

    static int report() { System.out.println("initialize"); return 0; }

    int x = report(); // <- [Step 2] Initialization

    Example () {
        System.out.println("execute"); // <- [Step 3] Execution
    }

}