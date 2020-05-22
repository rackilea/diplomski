class InStreamPrinter extends Thread {
    InputStream is;

    InStreamPrinter(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try (InputStreamReader isr = new InputStreamReader(is); 
            BufferedReader br = new BufferedReader(isr);) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}