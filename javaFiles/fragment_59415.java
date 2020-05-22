public class MyDrawPanel extends JPanel{
    MyDrawPanel()
         {
         setOpaque(true);
         }


    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillRect(20,50,100,100);
    }
    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new MyDrawPanel());
        frame.setBounds(10,10,500, 500);
        frame.setVisible(true);
    }

}