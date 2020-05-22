Scanner in = new Scanner(new File("strings.test"));
List<String[]> lines = new ArrayList<>();
while(in.hasNextLine()) {
    String line = in.nextLine().trim();
    String[] splitted = line.split(", ");
    for(int i = 0; i<splitted.length; i++) {
        //get rid of additional " at start and end
        splitted[i] = splitted[i].substring(1, splitted[i].length()-1);
    }
    lines.add(splitted);
}

//pretty much done, now convert List<String[]> to String[][]
String[][] result = new String[lines.size()][];
for(int i = 0; i<result.length; i++) {
    result[i] = lines.get(i);
}

System.out.println(Arrays.deepToString(result));