final JFileChooser fc = new JFileChooser();
int returnVal = fc.showSaveDialog(aComponent); //parent component to JFileChooser
if (returnVal == JFileChooser.APPROVE_OPTION) { //OK button pressed by user
        File file = fc.getSelectedFile(); //get File selected by user
        o = new BufferedWriter(new FileWriter(file)); //use its name

        ...
        //your writing code goes here
}