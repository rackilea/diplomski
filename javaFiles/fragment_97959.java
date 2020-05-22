public class SomeClass implements ActionListener{

    SomeClass(){
    Button aButton  = new Button("Click Me");
    aButton.addActionListener(this);
    }

     public static void main(String[] args) {
       SomeClass object = new SomeClass();
     }

    public void actionPerformed(ActionEvent e) {
     //do Something when user clicks the button
    }
}