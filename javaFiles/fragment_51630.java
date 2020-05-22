public static void main(String[] args) {

    Set<Integer> tmp = new HashSet<>();
    List<Integer> check = new ArrayList<>();
    check.add(1);
    check.add(2);
    List<Integer> list = new ArrayList<>();
    for(int i = 1; i <= 5; i++){
        list.add(i);
    }

    tmp.addAll(list);
    tmp.removeAll(check);
    System.out.println(tmp);
}