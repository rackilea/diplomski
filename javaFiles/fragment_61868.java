public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(i);
                Thread.sleep(2000);
            } //System.out.println(stem[0]);
            catch (InterruptedException ex) {
                Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }