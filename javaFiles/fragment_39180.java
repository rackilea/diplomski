public static String[] InsertSort(String[] args) {
  int i, j;
  String key;

  System.out.println(Arrays.toString(args));

  for (j = 1; j < args.length; j++) { //the condition has changed
    key = args[j];
    i = j - 1;
    while (i >= 0) {
      System.out.printf(" %s -> %s = %d\n", key, args[i], key.compareTo(args[i]));
      if (key.compareTo(args[i]) > 0)//here too
        break;
      args[i + 1] = args[i];
      i--;
    }
    args[i + 1] = key;
  }

  return args;
}

public static void main(String[] args) throws FileNotFoundException, IOException {
  Scanner scan = new Scanner(System.in);
  System.out.println("Insertion Sort Test\n");

  System.out.println("Enter name of file to sort: ");
  String name = scan.nextLine();

  File file = new File(name);
  String sb = (new Scanner(file)).useDelimiter("\\Z").next();

  //We now split the line on the "," to get a string array of the values
  List<String> list = Arrays.asList(sb.split("\n\r?"));

  ArrayList<String> list2 = new ArrayList<>();
  list.stream().forEach((s) -> {
    list2.add(s.trim());
  });

  System.out.println(list2);
  /* Call method sort */
  String[] store = list2.toArray(new String[]{});

  InsertSort(store);

  System.out.println(Arrays.asList(store));

  int n = store.length;

  try (FileWriter fw = new FileWriter("sorted.txt")) {
    StringBuilder b = new StringBuilder();
    for (String s: store)
      b.append(s).append("\n");

    fw.write(b.toString());
  }
}