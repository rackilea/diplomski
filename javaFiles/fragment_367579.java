public class MyApplication {
     public static void main(String[] args) {

         // set system properties here that affect Quaqua
         // for example the default layout policy for tabbed
         // panes:
         System.setProperty(
            "Quaqua.tabLayoutPolicy","wrap"

         );

         // set the Quaqua Look and Feel in the UIManager
         try {
              UIManager.setLookAndFeel(
                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel();
              );
         // set UI manager properties here that affect Quaqua
         ...
         } catch (Exception e) {
             // take an appropriate action here
             ...
         }
         // insert your application initialization code here
         ...
     }
}