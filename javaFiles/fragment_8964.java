public class DroppedFileAsArgumentDemo {

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.println("No file");
        } else {
            // Print the path of the file
            System.out.println(args[0]);
        }
        // To let you see the result before the window closes
        Thread.sleep(10000);
    }

}