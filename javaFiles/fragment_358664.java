public class Main {

      public static void main(String[] args) {   
        JFrame frame = new JFrame( "Geometrica" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(420, 250);
        frame.setBackground( new Color(250, 250, 250) );

        frame.setLocationRelativeTo(null);
        IntroPanel p=new IntroPanel();
        frame.getContentPane().add(p);
        frame.setVisible(true);
        p.animate();        

       }
}