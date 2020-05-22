String filename="Elements.txt";
PrintWriter pw = new PrintWriter(new FileWriter(filename,true));

String element= ... ;
pw.write(element + ",");

// ... more ...

String valence=...;
pw.write(valence);

pw.println();

pw.close();