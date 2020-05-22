BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
    String line = null;
    ArrayList<String> block = new ArrayList<String>();
    String tmp="";
    while ((line = reader.readLine()) != null) {
        if(line.equals(""))
        {
            block.add(tmp);
            tmp="";
        }
        else
        {
            tmp = tmp + line;
        }
    }
    block.add(tmp);
            reader.close();
    System.out.println(block.size());
    System.out.println(block.toString());