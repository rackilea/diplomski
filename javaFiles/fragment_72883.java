String[] wrds   = counter.getWords(WordCounter.SortOrder.BY_FREQUENCY);
int[] frequency = counter.getFrequencies(WordCounter.SortOrder.BY_FREQUENCY);        
String texttoWrite = "";
int n = counter.getEntryCount();
for (int i=0; i<n; i++) 
{
    texttoWrite += frequency[i] + " " + wrds[i]+" "+ counter.getWordCount();
}
try{
 FileWriter fstream = new FileWriter("out.txt");
 BufferedWriter out = new BufferedWriter(fstream);
 out.write(texttoWrite);
 out.close();
 }catch (Exception e){
  System.err.println("Error: " + e.getMessage());
 }
}