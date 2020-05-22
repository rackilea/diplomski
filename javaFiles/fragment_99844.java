public class UI extends javax.swing.JFrame {
    // some code
    private javax.swing.JTextArea txtRespond;

    protected void appendResponse(String response){
        txtRespond.append(response);
    }

    // your other methods and code if you have.
}


class Backend extends UI {
    // some code
    void start() {
        appendResponse(Bot + ": hello, " + Name + "\n"); 
    }
}