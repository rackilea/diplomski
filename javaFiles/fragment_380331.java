JFileChooser chooser = new JFileChooser();
int returnVal = chooser.showOpenDialog(null); //replace null with your swing container
File file;
if(returnVal == JFileChooser.APPROVE_OPTION)     
  file = chooser.getSelectedFile();    
}

JTextArea text = new JTextArea();
BufferedReader in = new BufferedReader(new FileReader(file));
String line = in.readLine();
while(line != null){
  text.append(line + "\n");
  line = in.readLine();
}