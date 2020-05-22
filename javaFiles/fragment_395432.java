Set<String> set = new HashSet<String>();

BufferedReader reader = new BufferedReader(new FileReader(new File("/path/to/yourFile.txt")));

String line;

while((line = reader.readLine()) != null) {

    // duplicate
    if(set.contains(line))
        continue;

    set.add(line);

    // do your work here

}