public class evttest implements ItemListener{

//Declared your arraylist checkboxes global. To access it in other part of code
static ArrayList<JCheckBox> checkboxes ;

public evttest(){

...

checkboxList();
//After calling checkboxesList() call add method to add itemlistener to each of them
this.add();
}


public static void checkboxList() {
checkboxes = new ArrayList<>();
JCheckBox box;

for (String element : songs) {
    System.out.println("Reached checkbox thing");
    System.out.println(element);
    box = new JCheckBox(element);

    checkboxes.add(box);
    panel.add(box);
    frame.pack();
}

frame.getContentPane().add(panel);
}

//this method adds ItemListener to all the 
//checkboxes you have in your ArrayList checkboxes
public void add(){
    for(JCheckBox cb : checkboxes){
        cb.addItemListener(this);
    }
}



@Override
public void itemStateChanged(ItemEvent e) {

    //If the item is selected then do something
    if(e.getStateChange() == ItemEvent.SELECTED){

        //cb is the checkbox on which your event occured.
        //You can then use cb to perform your required operation

        JCheckBox cb = (JCheckBox)e.getSource();
        System.out.println("clicked item is: " + cb.getText());
    }
}

public static void main(String...args){
    new evttest();
    }


}