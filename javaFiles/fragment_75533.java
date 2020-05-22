public static class OutputThread extends Thread {
        private InputStream inputstream;
        Scanner scanner;
        String message;
        public OutputThread(OutputStream outputstream) {
            this.inputstream = inputstream;
}
        @Override
        public void run() {
            ObjectOutputStream output = new ObjectOutputStream(outputstream);
            scanner = new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("InputMessage: ");
                    message = scanner.nextLine();
                    System.out.println(message);
                    output.writeObject(message); //send the string to the server
                output.flush();
                } catch (IOException exception) {
                    exception.printStackTrace();
                    break;
}}}}}