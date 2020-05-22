List<Integer> intList = new ArrayList<Integer>();
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    while (!str.isEmpty()) {
        intList.add(Integer.parseInt(str)+10);
        str=br.readLine();

    }
    System.out.println(intList);}