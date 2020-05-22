public class example extends JFrame implements ActionListener{
    javax.swing.Timer timer = new javax.swing.Timer(1000,  this);
    int c = 10;

    public example(){
        timer.start();
        initComponents(); // this is auto generated when creating JFrame

    @Override
    public void actionPerformed(ActionEvent e) {
        jLabel1.setText(""+c--);
        if (c == -1) {
            timer.stop();
        } 
    }

}