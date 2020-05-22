public class Confirmation extends JDialog{
    JButton clrBtn;

    public Confirmation(SoupPage sp){

         clrBtn = new JButton("Clear");
         clrBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            sp.soupLabel.setText("some other text bla bla");
            }
         });
    }
}