public class Test{

//create the array
JLabel[] labels = new JLabel[100];

public Test(){
  //loop through them and set their text value
  for(int i = 0; i < labels.length; i++){
    labels[i] = new JLabel("foo");
  }
}