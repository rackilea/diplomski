List list = new ArrayList();
Scanner in = new Scanner(file);
while(in.hasNext()) {
    String line = in.nextLine();
    String[] splitLine = line.split(";",5);
    String identifier = splitLine[0] + splitLine[4];
    if(list.contains(identifier)) {
        line = line + " #" + (list.indexOf(identifier) + 1));
    }
    else {
        line = line + " #" + (list.size() + 1);
        list.add(identifier);
    }
    System.out.println(line);
}