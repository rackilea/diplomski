public class Test{
    boolean isGreen;  // flag that indicates the content

    public Test(){      
        JFrame f = new JFrame ("Test"); // the Frame
        f.setLayout (new BorderLayout());

        JPanel p = new JPanel(new BorderLayout()); // the content Panel 
        f.add(p, BorderLayout.CENTER);

        JPanel green = new JPanel(); // the green content
        green.setBackground(Color.GREEN); 

        JPanel red = new JPanel(); // the red content
        red.setBackground(Color.RED); 

        p.add(green); // init with green content
        isGreen = true;

        JButton b = new JButton ("flip"); // the flip button
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p.removeAll(); // remove all of old content                    
                if(isGreen){
                    p.add(red); // set new red content
                    isGreen = false;
                } else {
                    p.add(green); // set new green content
                    isGreen = true;
                }
                p.revalidate(); // invalidate content panel so component tree will be reconstructed
                f.repaint(); // repaint the frame so the content change will be seen
            }
        });
        f.add (b, BorderLayout.SOUTH);        
        f.pack();
        f.setSize(250,330);
        f.setVisible (true);
    }
    public static void main (String [] args){
       new Test();
    }
}