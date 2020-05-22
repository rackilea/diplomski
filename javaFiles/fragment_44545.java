public class Main{
    public static void main(String []args){
        JLabel c=new JLabel();
        c.setIcon(new ImageIcon("picture.png"));
        JFrame frame = new JFrame();
        frame.setBackground(Color.WHITE);
        frame.setUndecorated(true);
        frame.getContentPane().add(c);
        frame.pack();
        frame.setVisible(true);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.dispose();
    }
}