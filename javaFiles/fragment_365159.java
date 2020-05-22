public class Rough2 extends JFrame{
    public static final int MAXITEMS = 100;
    JPanel panel = new JPanel(new BorderLayout()); // You should use a layout on the panel for the textfield and the list
    JTextField textField = new JTextField(5);

    String[] myDataBase = { "Alice", "Bob", "Rose", "Coggu", "Alpha", "david","peter", "max" };
    String[] listItems;
    JList theList = new JList();

    public Rough2() {
        this.add(panel);
        panel.setPreferredSize(new Dimension(500, 300));
        panel.add(textField, BorderLayout.NORTH); // you should add the components using the layout
        panel.add(theList, BorderLayout.WEST); // added using the layout also

        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char newChar = e.getKeyChar();

                String compareString = "";
                if (isAsciiPrintable(newChar)) { //you should check if the key that triggered the event is a printable character
                    compareString = ("" + textField.getText() + newChar); // add the character if it's printable
                }
                else {
                    compareString = ("" + textField.getText()); // do not add it if it's not printable
                }

                System.out.println(compareString);

                listItems = new String[MAXITEMS];

                if (compareString.trim().length() > 0 ){
                    int counter = 0;
                    for (int i = 0; i < myDataBase.length; i++) {
                        if (counter < MAXITEMS) {
                            if (myDataBase[i].length() >= compareString.length() &&
                                    myDataBase[i].substring(0, compareString.length()).equalsIgnoreCase(compareString)) {
                                listItems[counter] = myDataBase[i];
                                counter++;
                            }
                        }
                    }
                }

                theList.setListData(listItems);
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
            }
        });
    }

    public static boolean isAsciiPrintable(char ch) {
        return ch >= 32 && ch < 127;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        final Rough2 answer = new Rough2();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                answer.pack();
                answer.setVisible(true);
            }
        });
    }
}