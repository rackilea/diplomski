public class X extends JFrame{

    X(){
          JButton btnOK=new JButton("OK");

        btnOK.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            lblA.setText("Hello"); // error here
        }
    });
     //        final JLabel lblA = new JLabel("");
    }

    JLabel lblA = new JLabel("");// Try to declare here outside of constructor.

    public static void main(String[] args){
        new X();
    }
}