public class Moteur implements ActionListener {
    private JLabel messageToHide;
    private JLabel messageToShow;

    public Moteur(JLabel messageToHide, JLabel messageToShow) {
        this.messageToHide = messageToHide;
        this.messageToShow = messageToShow;
    }

    public void actionPerformed(ActionEvent e) {
        messageToHide.setVisible(false);
        messageToShow.setVisible(true);
    } 
}