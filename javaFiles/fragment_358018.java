public static void groupLogFile(JTextArea theLogs) {
    //This is used to get each line one by one
    Scanner sc = new Scanner(theLogs.getText());

    //We are using a HashMap to store the lines in function of the task numbers
    HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();

    //We are now reading each line one by one
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        //With this regex we get at group 2 the task number
        Pattern pattern = Pattern.compile("(\\(default task-(\\d+)\\))");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            //Task number
            int task_number = Integer.parseInt(matcher.group(2));
            //We get other lines with same task number (if exist)
            List<String> get;
            if(map.containsKey(task_number)){
                get = map.get(task_number);
            } else {
                get = new LinkedList<String>();
            }
            get.add(line);
            //We update the list
            map.put(task_number, get);
        }
    }
    sc.close();

    //Ordering the map by task number
    Comparator<Integer> comparator = new Comparator<Integer>() {
          public int compare(Integer o1, Integer o2) {
              return o1.compareTo(o2);
          }
    };
    TreeMap<Integer, List<String>> ordered = new TreeMap<Integer, List<String>>(comparator);
    ordered.putAll(map);

    //Print results
    for(Entry<Integer, List<String>> e : ordered.entrySet()){
        for(String s : e.getValue())
            System.out.println(s);
    }
}