List<String> names = new ArrayList<String>();
BufferedReader br = null;

try {
    String currLine;

    br = new BufferedReader(new FileReader("StateCityDetails.txt"));

    while ((currLine = br.readLine()) != null) {
        String[] parts = currLine.split("-");
        for (int i=0; i < parts.length; ++i) {
            names.add(parts[i].replaceAll(" ", ""));
        }
    }

} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
    if (br != null) br.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

// convert the List to an array of String (if you require it)
String[] nameArr = new String[names.size()];
nameArr = names.toArray(nameArr);

// print out result
for (String val : nameArr) {
    System.out.println(val);
}