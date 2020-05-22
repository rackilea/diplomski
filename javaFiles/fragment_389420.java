List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("a");
    list.add("a");
    list.add("a");

int countA=Collections.frequency(list, "a");
int countB=Collections.frequency(list, "b");
int countC=Collections.frequency(list, "c");