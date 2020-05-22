BufferedReader infile = new BufferedReader(new FileReader(args[0]));
TreeMap<String, ArrayList<String>> tm = new TreeMap<String, ArrayList<String>>();

String line;
while ((line = infile.readLine()) != null) {
    ArrayList<String> typetopres = new ArrayList<String>(
        Arrays.asList(line.split(",")));

    String type= typetopres.remove(0);

    tm.put(type, typetopres);
}

System.out.println(tm);

infile.close(); // don't forget to cleanup