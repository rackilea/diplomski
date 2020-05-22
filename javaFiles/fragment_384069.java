Path p1 = Paths.get("C:/Users/Green/documents/dictionary.txt");
        Scanner sc = new Scanner(p1.toFile()).useDelimiter("\\s*-\\s*");
        List<String> myList = new ArrayList<String>();
        while (sc.hasNext()) {
            myList.add(sc.next());
        }