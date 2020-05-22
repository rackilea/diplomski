private JTextField[] textFields;  // this creates your array

public MyClass(){        // this is the constructor of your class (I don't know how it is called) 
    initComponents();    // auto generated code from NetBeans to initalize your GUI elements
    // init your array
    textFields = new JTextField[12];  // 12 if I counted correctly
    // fill it
    textFields[0] = koontf;
    textFields[1] = baamtf;
    textFields[2] = sachitf;
    textFields[3] = fakertf;
    textFields[4] = phonsekaltf;
    textFields[5] = lauretf;
    textFields[6] = yeontf;
    textFields[7] = aguerotf;
    textFields[8] = agnistf;
    textFields[9] = lokitf;
    textFields[10] = lawliettf;
    textFields[11] = ryuzakitf;
}

private void loadActionPerformed(java.awt.event.ActionEvent evt){
    int line = 0;
    try(Scanner scanner = new Scanner(new File("reload.txt"))){
        while(scanner.hasNextLine()){
            textFields[line++].setText(scanner.nextLine());
            if(line == textFields.length){
                break;
            }
        }
    }catch(FileNotFoundException ex){
        Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, ex);
    }
    koontf.requestFocus();  // you can only call request focus on one element at a time (it does not make sense to call it on all textfields
}