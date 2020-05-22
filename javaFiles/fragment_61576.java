try {
    BufferedReader br = new BufferedReader(new FileReader("D:\\a.txt"));
    int counter = 0;
    ArrayList<String> list = new ArrayList<String>();
    for (String line; (line = br.readLine()) != null;) {
        counter++;

        if (counter > 51) {
            line = line.trim();
            list.addAll(Arrays.asList(line.split("\\s*,\\s*")));
        }
    }

    String[] array = new String[list.size()];
    array = list.toArray(array);

    for (int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
    }
} catch(Exception e) {
    System.out.println(e);
}