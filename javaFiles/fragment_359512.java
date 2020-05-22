CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
String [] Line;
while ((Line = reader.readNext()) != null) {
    for(int i = 0 ; i < Line.length ; i++)
        if(Line[i].length>0) System.out.println(Line[i]);
        else System.out.println("0");
}