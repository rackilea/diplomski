String text =
        "#Hi, this is a sample file.\n" +
        "\n" +
        "\"abcd\" = 12; \r\n" +
        "\"abcde\"=16;\n" + 
        "  # \"ignore\" = 13;\n" +
        "\"http\" = 32;  # Comment here \r" + 
        "\"zzz\" = 666;  # Out of order! \r" + 
        "   \"sip\"  =  21 ;";

    System.out.println(text);
    System.out.println("----------");

    SortedMap<String,Integer> map = new TreeMap<String,Integer>();
    Scanner sc = new Scanner(text).useDelimiter("[\"=; ]+");
    while (sc.hasNextLine()) {
        if (sc.hasNext("[a-z]+")) {
            map.put(sc.next(), sc.nextInt());
        }
        sc.nextLine();
    }
    System.out.println(map);