Scanner s = new Scanner(new File("D:\\ref.txt"));
    ArrayList<String> list = new ArrayList<String>();
    while (s.hasNextLine()){
        list.add(s.nextLine());
    }

    for(int i = 0; i < list.size(); i++)
    {
        System.out.println(i + ":" +list.get(i));
    }

    s.close();