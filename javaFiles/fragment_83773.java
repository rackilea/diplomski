public static void main( String [] args ) {
    JLabel label = new JLabel("Some info");
    JButton button = new JButton("Ok");
    JPanel panel = new JPanel();
     panel.add( button );

    JFrame frame = ... 

    frame.add( label, BorderLayout.NORTH );
    frame.add( panel , BorderLayout.CENTER);
    ....

}