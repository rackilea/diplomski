private void makeGUI()
{
    final JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(new FlowLayout());

    // include: "class AnswerWorker" code here.
    // include: "JButton" b code here.

    f.getContentPane().add(b);
    f.getContentPane().add(new JButton("Nothing"));
    f.pack();
    f.setVisible(true);
}