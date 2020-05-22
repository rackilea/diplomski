try{
    extracted = Integer.parseInt(extracted.getText());
    System.out.println("the number was: "+ extracted);
} catch(NumberFormatException exception) {
    System.out.println(label.getText() + " is not a number");
}