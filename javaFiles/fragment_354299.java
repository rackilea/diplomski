public static void main(String[] args) {
    Integer needle = 20;

    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
    hm.put(1111, new ArrayList<Integer>());
    hm.get(1111).add(1);
    hm.get(1111).add(2);
    hm.get(1111).add(3);
    hm.get(1111).add(4);
    hm.get(1111).add(5);
    hm.get(1111).add(6);

    hm.put(2222, new ArrayList<Integer>());
    hm.get(2222).add(8);
    hm.get(2222).add(10);
    hm.get(2222).add(11);

    hm.put(3333, new ArrayList<Integer>());
    hm.get(3333).add(15);
    hm.get(3333).add(19);
    hm.get(3333).add(20);
    hm.get(3333).add(31);

    for (Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()) {
        ArrayList<Integer> v = entry.getValue();
        if (v.contains(needle)){
            System.out.println(entry.getKey());
            break;
        }
    }
}