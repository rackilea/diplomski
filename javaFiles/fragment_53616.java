String line;

    while((line = reader.readLine()) != null)
        if(line.equals(fruit))
            break;

    ArrayList<String> lines = new ArrayList<>();
    while((line = reader.readLine()) != null)
        lines.add(line);