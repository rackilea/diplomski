// Other code goes here.
ArrayList<String> list = new ArrayList<String>();
String line;
    while ((line=br.readLine())!=null) {
        String[] s = line.split(" ");
        list.add(s[0]);
        list.add(s[1]);
    }
br.close();