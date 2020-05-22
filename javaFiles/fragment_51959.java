//Class A - button's - ActionListener.
button.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent A){

//Create a empty variable: String, with the name of: value.
String value = "";

//Value, gets the text of the: txtAreaA.
value = txtAreaA.getText();

//Calls the: classB, and create a new object from them.
classB cb = new classB();

//cb.txtAreaB(); is the method who creates a: JFrame, with JTextArea, in classB.
cb.txtAreaB();

//Now, just call the object, and set the text: value.
cb.txtAreaB.setText(value);
}});