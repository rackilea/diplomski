public static void main(String[] args) {
InputStream stream = Prep1.class.getResourceAsStream("words.txt");
Scanner scanner = new Scanner(stream);             
boolean wordFound = false;//initially set it to false

String word = JOptionPane.showInputDialog("Input word to look for: ");

while(scanner.hasNextLine()){

    if(word.equals(scanner.next().trim())){
 //after the loop would be a better place to show below notification
        //JOptionPane.showMessageDialog(null, word + " found"); // found

        wordFound = true;//make the flag as true and break out of the loop
        break;
    }/*else{
        JOptionPane.showMessageDialog(null,word + " not found"); // not found
        break;
    }*/
}
if(wordFound)
        JOptionPane.showMessageDialog(null, word + " found"); // found
else
        JOptionPane.showMessageDialog(null,word + " not found");