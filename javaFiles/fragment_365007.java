public class Test extends JFrame {

    JTextField jtf1 = new JTextField(10);
    JTextField jtf2 = new JTextField(10);
    JTextField jtf3 = new JTextField(10);
    JTextField jtf4 = new JTextField(10);
    JButton button = new JButton("Button");

    public Test() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(jtf1);
        panel.add(jtf2);
        panel.add(jtf3);
        panel.add(jtf4);

        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener(){    // add a listener to the button
            public void actionPerformed(ActionEvent e){  // perform the action when clicked
                String str1 = jtf1.getText();     // get input from text field 1
                String str2 = jtf2.getText();     // get input from text field 2
                String str3 = jtf3.getText();     // get input from text field 3
                String str4 = jtf4.getText();     // get input from text field 4

                // do something with strings
                someMethod(str1, str2, str3, str4);  // pass to someMethod
            }
        });
    }

    private void someMethod(String s1, String s2, String s3, String s4){
        // dumb example
        System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Test test = new Test();
                test.setDefaultCloseOperation(EXIT_ON_CLOSE);
                test.pack();
                test.setVisible(true);
            }
        });
    }
}