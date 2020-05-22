public static void main(String[] args) throws Exception {
    Runtime.getRuntime().exec("calc.exe").waitFor();
    while (processIsRunning("Calculator.exe")) {
        Thread.sleep(1000); // make this smaller if you want
    }
    System.out.println("Program has been closed successfully");
}