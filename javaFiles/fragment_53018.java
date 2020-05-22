JCheckBox checkBox = new JCheckBox(listOfFiles[i].getName());
    box.add(checkBox);

    //you could keep reference in a List such as 
    List<JCheckBox> listOfChkBox = new ArrayList<>(); //class variable 
    listOfChkBox.add(checkBox);

    //or a map 
    Map<String,JCheckBox> mapOfChkBox = new HashMap<>(); //class variable
    mapOfChkBox.add(listOfFiles[i].getName(), checkBox);