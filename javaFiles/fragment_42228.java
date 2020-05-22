File Orig_outFile = new File("C:\\voters.txt");
BufferedReader infile = new BufferedReader(new FileReader(Orig_outFile));

vNum = JOptionPane.showInputDialog("Enter voters number: ");
String line = null;
String something = "VOTED";
while((line = infile.readLine()) != null) {
    String [] info = line.split("/");

    /* Assuming You Are Entering Voter's Number & Not Voter's Name */
    if(info[1].equalsIgnoreCase(vNum)) {
        if(info[0].equalsIgnoreCase(something)) {
            JOptionPane.showMessageDialog(null, "Voter already voted or 
                                          Voter not registered. Please try again");
            /* Please Note That You Are Currently Iterating File */
            /* If You Do This Here, You'll End Up Checking Same Records */
            /* You'll Have To Replace Outer `if` with `while` */
            vNum = JOptionPane.showInputDialog("Enter voters number: ");
        } else {
            President();
            break;
        }
    }
}
infile.close();