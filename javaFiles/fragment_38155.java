// No need to put the lines into a list first;
        // just sort them by hash as we read them
        List<List<String>> orderedList = new ArrayList<>(maxHash3 + 1);
        // add empty array lists to ordered list to hold the lines
        for (int ix = 0; ix <= maxHash3; ix++) {
            orderedList.add(new ArrayList<>());
        }

        while((line = bufferedReader.readLine()) != null){
              // Use email as key
              String key = line.substring(0,line.indexOf(','));
              int index = hashFunc3(key);
              // add line to inner ArrayList
              orderedList.get(index).add(line);
        }