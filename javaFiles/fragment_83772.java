public static void main( String [] args ) {
    JLabel label = new JLabel("Some info");
    JButton button = new JButton("Ok");

    JFrame frame = ... 

    frame.add( label, BorderLayout.NORTH );
    frame.add( button , BorderLayout.CENTER );
    ....

}