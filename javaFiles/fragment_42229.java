File Orig_outFile = new File("C:\\voters.txt");
BufferedReader infile = new BufferedReader(new FileReader(Orig_outFile));
Map<String,String> map = new HashMap<>();
String something = "VOTED";

String line = null;
while((line = infile.readLine()) != null) {
    String [] info = line.split("/");
    map.add(info[1],info[0]);
}
infile.close();

while(true) {
    vNum = JOptionPane.showInputDialog("Enter Voter's Number: ");
    if(map.contains(info[1]) && !map.get(info[1]).equalsIgnoreCase(something)) {
        President();
        break;
    } else {
        JOptionPane.showMessageDialog(null, "Voter already voted or 
                                          Voter not registered. Please try again");
    }
}