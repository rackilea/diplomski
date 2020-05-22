StringBuilder sb = new StringBuilder();
    String line = br.readLine();
    while (line != null) {
        ArrayList temp = new ArrayList<Integer>();
        temp.addAll(Arrays.asList(line.split(" ")));
        temp = getIntegerArray(temp);

        Planets.add(temp);

        line = br.readLine();
    }