try{
    date2 = dateFormat.parse(textBox.getText());
}catch(ParseException e){
    date2 = null; // For Null;
    // date2 = new Date(); For Current Date
    // date2 = new Date(0); For Default Date
}