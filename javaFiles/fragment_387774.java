private int a;
public ConfirmDialog(String quest) {
    int a = JOptionPane.showConfirmDialog(null,
            quest,
            "Confirmation", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
}

public int getA(){
    return a;
}