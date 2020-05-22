package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;


public class NewJFrame extends javax.swing.JFrame {

  /** Creates new form NewJFrame */
  public NewJFrame() {
    initComponents();
  }


  public String sendMessage(String username, String message){

    BufferedReader in = null;
    String data = null;
    try{


        HttpClient client = new DefaultHttpClient();
        URI website = new URI("http://abc.com/user_send.php?username="+username+"&message="+message);

        //!!!this is never used
        HttpPost post_request = new HttpPost();
        post_request.setURI(website);


        HttpGet request = new HttpGet();

        request.setURI(website);
        //executing actual request
            HttpResponse response = client.execute(request);

        in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer sb = new StringBuffer("");
        String l = "";
        String nl = System.getProperty("line.separator");
        while ((l = in.readLine()) != null) {
            sb.append(l);

        }
        in.close();

        data = sb.toString();
        System.out.println("Success:\n" + data);


        return data;
    }catch (Exception e){
        return "ERROR";
    }

  }


  @SuppressWarnings("unchecked")
  private void initComponents() {

    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jButton1.setText("jButton1");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .add(64, 64, 64)
            .add(jButton1)
            .addContainerGap(239, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .add(58, 58, 58)
            .add(jButton1)
            .addContainerGap(213, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    sendMessage("ondra", "textX");
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {

        public void run() {
            new NewJFrame().setVisible(true);
        }
    });
  }

  private javax.swing.JButton jButton1;

}