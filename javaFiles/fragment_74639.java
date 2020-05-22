List tilesList = new ArrayList<String>();
// etc.

FileReader fr = new FileReader(file_path);
BufferedReader br = new BufferedReader(fr);
String s = null // I think this should be null, so that if there are no lines, 
                // you don't have problems with str.split();
while((s = br.readLine()) != null) {
  String[] line = str.split("<.>");
  tilesList.add(line[1]);
  // etc.
}
fr.close();

String[] tiles = tilesList.toArray(new String[tilesList.size()]);
// etc.