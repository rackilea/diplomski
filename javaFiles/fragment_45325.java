public static void main(String[] args) {
try {
    br = new BufferedReader(new FileReader(theFile));
    String line = null;

    while ((line = br.readLine()) != null) {
        String[] aLine = line.split("\t"); // Also as kaykay mentioned change /t to \t
        //br.readLine();  // You are reading the line again - Comment it out 
        numLine.add(aLine);
    }
} catch (IOException e){
} finally {
    try {
        br.close();
    } catch (Exception e) {
    }
}

for (int i=0; i < numLine.size(); i++){
    for (int j = 0; j < numLine.get(i).length; j++){
        System.out.print(numLine.get(i)[j] + " ");
        //  if (!((numLine.get(i)[j]).equals("\t"))){
        intList.add(Integer.parseInt(numLine.get(i)[j]));
    }
System.out.println();
}