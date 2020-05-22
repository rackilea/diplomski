public class GUI extends JFrame{
    // Note: this should probably not be a static variable
    // You can use a private, non-static variable and create a getter/setter method for it
    public static String LCDString = ""; 

    public GUI(){
        initComponents();
    }

    // Note: methods in Java start with a lowercase letter
    public void refreshLCD(){
        lblLCD.setText(LCDString);
    }
}