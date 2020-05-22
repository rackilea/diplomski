BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
    String line;
    ArrayList<Entry> list = new ArrayList<Entry>();
    while((line = reader.readLine()) != null) {
        list.add(new Entry(line));
    }
    Collections.sort(list);

    // list is sorted!