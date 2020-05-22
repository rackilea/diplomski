public static void listDictionary()throws IOException
{
    BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
    String aLineFromFile = null;
    while ((aLineFromFile = br.readLine()) != null){
            JOptionPane.showMessageDialog(null, aLineFromFile);
    }        
    br.close();
    return;
}