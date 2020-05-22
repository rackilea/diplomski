char[][] array;
try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
    List<char[]> list = new ArrayList<>();
    for (String line; (line = in.readLine()) != null; )
        list.add(line.toCharArray());
    array = list.toArray(new char[list.size()][]);
}