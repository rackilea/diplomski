//Suppose you have a custom Frame in your Form class
class InsertApplicationsForm extends JFrame{
//Some stuff
//...

public InsertApplicationsForm(){
//Implement
    //DO NOT ADD setDefaultCloseOperation
setVisible(true);
}

addWindowListener(new WindowAdapter(){

     @Override
    public void windowClosing(WindowEvent e){
        InsertApplicationsForm.this.dispose();
    }

});