public class FrontGUILinkerController {
   public MAINGUI maingui;
   private FrontGUILinker frame;

   // **** note change
   public FrontGUILinkerController(MAINGUI parent, FrontGUILiner frame) {
      maingui = parent;
      this.frame = frame;  // **** added
      // frame = new FrontGUILinker(); // **** commented out

      // Add listener to Create Link button
      frame.btnCreateLink.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
             System.out.println("Create Link button has been clicked");
         }});
   }
}