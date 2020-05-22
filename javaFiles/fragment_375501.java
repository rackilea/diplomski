public class TestJFrame extends JFrame {

        /**
         *
         */
        public TestJFrame() {

        //set test frame 
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setPreferredSize(new Dimension(100,100));

             //make a date chooser 
            JDateChooser dateChooser = new JDateChooser();
            //set date format 
            dateChooser.setDateFormatString("yyyyMMdd");
            //set date 
            dateChooser.setDate(new Date());

            //add to test frame 
            getContentPane().add(dateChooser);
            pack();
            setVisible(true);

        }

        /**
         * @param args
         */
        public static void main(String[] args) {

            new TestJFrame();

        }
    }