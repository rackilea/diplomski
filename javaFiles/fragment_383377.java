JCheckBox[] extras = new JCheckBox[6];
//add items

//Don't use raw types! 
ArrayList<JCheckBox> selectedExtra = new ArrayList<>();

for (int i=0; i<extras.length ; i++){
    if(extras[i].isSelected()){  
       selectedExtra.add(extras[i]); // add the selected extras 
    }
 }