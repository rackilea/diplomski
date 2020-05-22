int mapcounter = 0;
        String line = filemap.nextLine();
        while(filemap.hasNextLine()) {
            if(!line.startsWith("#")) {

               // split the two node column into two values.
                String[] words = line.split("\\s+");

                if(!map.containsKey(word[0])){
                    map.put(word[0],mapcounter++);
                }
                if(!map.containsKey(word[1])){
                    map.put(word[1],mapcounter++);
                }
            }
            line = filemap.nextLine();
        }