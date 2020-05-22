class Dictionary{
 ArrayList<String> words = new ArrayList<String>(); // or you can use an ArrayList
 int numwords;String filename;

// constructor: read words from a file
public Dictionary(String filename){ 
     this.filename =filename;
 }
BufferedReader br  = null;
String line;

try {

    br = new BufferedReader(new FileReader("game-words.txt"));

while ((line = br.readLine()) != null){
        words.add(line.trim());
}
} catch (IOExecption e) {

    e.printStackTrace();
}

}