public static void main(String args[]) {
    /*...*/
    try {
        ip = InetAddress.getLocalHost();
        name.setText(ip.getHostName());
    } catch (Exception e) {
    }
}

InetAddress ip;
// Variables declaration - do not modify 
private javax.swing.JLabel l1;
private javax.swing.JLabel name;