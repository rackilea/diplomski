class SizeComarator implements Comparator<Set<?>> {

    @Override
    public int compare(Set<?> o1, Set<?> o2) {
        return Integer.valueOf(o1.size()).compareTo(o2.size());
    }
}

    ArrayList<Set<String>> arrayList = new ArrayList<Set<String>>();
    Set<String> set1 = new HashSet<String>();
    set1.add("A");
    set1.add("B");
    Set<String> set2 = new HashSet<String>();
    set2.add("A");
    arrayList.add(set1);
    arrayList.add(set2);
    Collections.sort(arrayList, new SizeComarator());
    System.out.println(arrayList);