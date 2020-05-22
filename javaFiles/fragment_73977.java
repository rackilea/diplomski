class mainGUI extends JFrame{
    private CardLayout card;
    private SoupPage sp;

    mainGUI(){
       card = new CardLayout();
       setLayout(card);
    }

    private void createSoupPage(){
      sp = new SoupPage(this);
      add(sp,"Soup Page");
    }

    public void setSoupPageText(String text){
      sp.soupLabel.setText(text);
    }


}

class SoupPage extends JPanel{
    mainGUI gui;
    JLabel soupLabel;
    JButton cfmBtn;

    SoupPage(mainGUI gui){
        this.gui = gui;

        soupLabel = new JLabel("blabla");

        cfmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Confirmation cfmPopUp = new Confirmation(gui);
            }
        });
    }
}



class Confirmation extends JDialog{
    JButton clrBtn;

    Confirmation(mainGUI gui){

         clrBtn = new JButton("Clear");
         clrBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            gui.setSoupPageText("some other text bla bla");
            }
         });
    }
}