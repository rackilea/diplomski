public class ValidateJSON implements ActionListener {

    private EditMSFrame editMSframe; 

    public ValidateJSON(EditMSFrame someInstance) {
        editMSframe = someInstance;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println(editMSframe.isValid(editMSframe.getTextPane().getText()));
    }

}