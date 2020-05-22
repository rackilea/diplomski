// "second" is mispelled
public boolean ismatch(JLabel firstChoiceLabel, JLabel secoundChoceLabel) {

    ImageIcon firstChoice = firstChoiceLabel.getIcon();
    ImageIcon secoundChoice = secoundChoiceLabel.getIcon(); 

    if (firstChoice.getImage() == secoundChoce.getImage()) {
        JOptionPane.showMessageDialog(null, " wowo you got it ^^");
        isMatch = true;
    } else {
        JOptionPane.showMessageDialog(null, "  notmatced");
        isMatch = false;

        // here set Icon to null or to background icon.
        firstChoiceLabel.setIcon(null);
        secoundChoiceLabel.setIcon(null);
    }
    return isMatch;
}