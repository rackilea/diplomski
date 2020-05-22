List<String> list = new ArrayList<String>(Arrays.asList("0.99998945", "line10Rule:14013", "noOfCommits:0"));
    ListIterator<String> i = list.listIterator();
    while(i.hasNext()) {
        String s = i.next();
        int p = s.indexOf(':');
        if (p > 0) {
            i.set(s.substring(0, p));
        } else {
            i.remove();
        }
    }
    System.out.println(list);