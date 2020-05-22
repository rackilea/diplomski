String twoVectors = "a=<-1,2,-3> b=<4,-5,6>";

    ArrayList<Integer> list = new ArrayList<Integer>();

    String[] tokens = twoVectors.split("[^\\d-]");

    for (String s : tokens)
        if (!s.equals(""))
            list.add(Integer.parseInt(s));

    System.out.println(Arrays.toString(list.toArray()));