ArrayList<Integer> intList = new ArrayList<Integer>();

for (int i = 0; i < 15; i++) {
    if (intList.size() == 10) {
        break;
    }
    intList.add(i);
    System.out.println(intList.get(i));
}