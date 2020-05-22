public class MainApp extends javax.swing.JFrame{
    private Stock st;

    private void stockMenuActionPerformed(java.awt.event.ActionEventevt){  

        if (tabbedpaneAgenda.indexOfTab("SKLAD") == -1)
        {
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\src\\pics\\stock.png");
            st = new stock(MainApp.this);
        }
        else {}
    }    
    private void acces_class(){
        st.doSomething();
    }