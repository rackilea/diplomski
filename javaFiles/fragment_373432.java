try{
    int sample = Integer.parseInt(jTextField1.getText());            
    int foo = Integer.parseInt(jTextArea1.getText());
} catch (NumberFormatException e){
    System.out.println("The text fields do not contain an appropriate number"); 
}