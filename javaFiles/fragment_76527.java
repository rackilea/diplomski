br=new BufferedReader(new FileReader(path));            
    boolean firstLine = true;               
    while ((line = br.readLine()) != null) {
        if (line.startsWith("child's Last Name")) {
            if (firstLine) {
                firstLine = false;
                continue;
            } 
            list.add(line);
        }               
    }