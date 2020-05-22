public class Something {

    JFrame frame;
    JLabel changeName;
    JButton button;
    public void gui(){
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //is just an example

        changeName = new JLabel("Stefan");
        //is just an example

        frame.getContentPane().add(changeName, BorderLayout.NORTH);

        button = new JButton("Change");
        button.addActionListener(new changeLabel());
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String args[]){
        new Something().gui();
    }

    class changeLabel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            changeName.setText("Andrei");
        }
    }
}