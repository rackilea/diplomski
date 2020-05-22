public static void main(String[] args) {
    try {
        System.out.println("Notepad Opening");
        Runtime runTime = Runtime.getRuntime();
        Process process = runTime.exec("notepad");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Notepad Closing");
        process.destroy();
    } catch (IOException e) {
        e.printStackTrace();
    }
}