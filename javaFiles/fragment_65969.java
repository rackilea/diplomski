public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==submit_btn)
    {
        String text = contact_text.getText();
        if(text.matches("\\d{10}")){
             // The text entered is a 10-digit number
        }else{
             // The text is not valid
        }
    }
}