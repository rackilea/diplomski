public static void main(String[] args) {
    int i = 0;
    boolean flag = true;
    try {
        while (i < 20 && flag) {
            TimeUnit.MINUTES.sleep(1);
            // Expecting some logic to increment the value of i

            // Or change the flag value of this to exit the while loop
        }
    } catch (Exception exp) {
        exp.printStackTrace();
    }
}