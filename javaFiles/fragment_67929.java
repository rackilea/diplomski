public class YourFrame extends JFrame implements ActionListener {

   private final JMenuItem menuA, menuB;

   public YourFrame(){
      super("Your app");
      JMenuBar menuBar = new JMenuBar();
      JMenu menuReviews = new JMenu("Reviews");
      menuA = new JMenuItem("A");
      menuB = new JMenuItem("B");
      ...
      menuReviews.add(menuA);
      menuReviews.add(menuB);
      menuBar.add(menuReviews);
      setJMenuBar(menuBar);
      ...
      menuA.addActionListener(this);
      menuB.addActionListener(this);
      ...
   }

   public void actionPerformed(ActionEvent event){
      if(event.getSource()==menuA){
         System.out.println("Menu A clicked");
         ...
      }else if(event.getSource()==menuB){
         System.out.println("Menu B clicked");
         ...
      }
   }

}