public class Foo {
    JButton button = new JButton("One");
    JButton button2 = new JButton("Two");

    class ButtLis implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {

            }
        }
    }
}