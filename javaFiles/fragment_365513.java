public class StopTest implements ActionListener {

            private JTextArea area;

            public StopTest(JTextArea area) {
                this.area = area;   
            }

            public void actionPerformed(ActionEvent e) {
                String stop = "The test has been stopped"; 
                area.setText(stop); 
            }
   }