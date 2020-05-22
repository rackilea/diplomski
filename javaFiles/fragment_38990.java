public class HomeBrowse extends javax.swing.JFrame {


    /**
     * Creates new form HomeBrowse
     */
    public HomeBrowse() {
        initComponents();
        this.setSize(743, 528);
        this.setLocationRelativeTo(this);
        setTitle(new NetInfo().say());
    }
}

public class NetInfo {

     public String say() {
       try {
           java.net.InetAddress i = java.net.InetAddress.getLocalHost();
           System.out.println(i.getHostName()); 
           jMenu2.setText(i.getHostName());
           return i.getHostName();
       }
       catch(Exception e){e.printStackTrace();}
       return null;
    }
}