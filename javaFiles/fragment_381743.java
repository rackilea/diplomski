public class Test {

    private static class TimeClass implements ActionListener {

        private int counter = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            System.out.println(counter);
        }

    }

    public static void main(String[] args) throws InterruptedException {    

        TimeClass tc = new TimeClass();
        Timer timer = new Timer (100, tc);
        timer.start();
        Thread.sleep(20000);    
    }
}