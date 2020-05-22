JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//... Your code here
JButton btnExit = new JButton("Exit");
btnExit.setFont(new Font("Tahoma", Font.PLAIN, 19));
btnExit.setBounds(766, 484, 127, 39);
if (btnExit.isSelected()==true) {
    System.exit(0);
}

btnExit.addActionListener((e)-> {
    int confirm = JOptionPane.showOptionDialog(frame,
            "Are You Sure to Close this Application?",
            "Exit Confirmation", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, null, null);
    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
});

frame.getContentPane().add(btnExit);
frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        int confirm = JOptionPane.showOptionDialog(frame,
                "Are You Sure to Close this Application?",
                "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
});
frame.setVisible(true);
frame.pack();