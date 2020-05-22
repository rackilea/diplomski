ArrayList<StackFile> arrayFile = new ArrayList<StackFile>(); 
    arrayFile.add(new StackFile("2", "Ramesh Tendulkar", "2008-12-31"));
    arrayFile.add(new StackFile("3", "John Machleyn", "2008-12-31"));


    FileReader fr = new FileReader("in.txt");
    BufferedReader br =new BufferedReader(fr); 
    String s;
    while((s = br.readLine()) != null) { 
        String[] spS = s.split("|")[1].split("+"); 
        arrayFile.add(new StackFile(spS[0],spS[1] ,spS[2]));
        } 
        fr.close(); 

    FileWriter fw = new FileWriter(new File("test.txt"));

    fw.write("+--------+-------------------------------+-------------+\n");
    fw.write("| ID     | Name                          | Date        |\n");
    fw.write("+--------+-------------------------------+-------------+\n");

    Iterator<StackFile> itS = arrayFile.iterator();

    while(itS.hasNext())
    {
        StackFile sf = itS.next();
        fw.write("| "+String.format("%-6s", sf.getID())+" | "+String.format("%-30s", sf.getName())+"| "+String.format("%-10s", sf.getDate())+"  |\n");
        fw.write((itS.hasNext())
                ?"|--------|-------------------------------|-------------|\n"
                :"+--------+-------------------------------+-------------+\n");

    }
    fw.close();