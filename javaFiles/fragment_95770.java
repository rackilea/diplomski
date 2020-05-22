public static void main(String[] args)
{
    ScrollableJTextArea sjta = new ScrollableJTextArea();
    JFrame frame             = new JFrame();
    JPanel center            = new JPanel();

    // I've read on many forums as well as heard from many fellow classmates 
    // that it's better to add content to a panel rather than the frame itself
    frame.add(center, BorderLayout.CENTER);
    center.add(sjta.jScrollPane);

    frame.setSize(400, 400);
    frame.setVisible(true);
}