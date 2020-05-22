FileWriter fout = new FileWriter("test.txt");
fout.write("Testing|10|true|two|false\n");
fout.write("Scanner|12|one|true|");
fout.close();
FileReader fin = new FileReader("test.txt");
Scanner src = new Scanner(fin).useDelimiter("[|\n]");