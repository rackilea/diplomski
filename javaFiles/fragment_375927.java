private static void readInputRun() {
    try {
        int input;
        String allInput = "";
        while((input = dis.read()) >= 0) {
            allInput += (char) input;
            System.out.print(allInput.charAt(allInput.length() - 1));

            if(allInput.endsWith("Start TLS\r\n")) {
                break;
            }
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
}