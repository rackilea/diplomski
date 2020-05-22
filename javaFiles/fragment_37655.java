Scanner in = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<String>();
    String line;
    while (!(line = in.nextLine()).equals("stop")) {
        list.add(line);
    }
    in.close();
    System.out.println(list);