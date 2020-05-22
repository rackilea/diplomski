`ArrayList myNumberList = getList();//get the list

    ArrayList result = new ArrayList<Integer>();
    for (int i = 0, n = numbers.size(); i < n -3; ) {
        int a = myNumberList.get(i++);
        int b = myNumberList.get(i++);
        int c = myNumberList.get(i++);
        int d = myNumberList.get(i++);
        results.add(a / b * c + d);
    }`