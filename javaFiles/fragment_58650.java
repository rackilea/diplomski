public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Integer> x = new HashMap<Integer, Integer>();
    ArrayList<Integer> m = new ArrayList<Integer>();
    for (int i = 0; i < 15; i++) {
        int tmp = sc.nextInt();
        if (!x.containsKey(tmp))
            x.put(tmp, 1);
        else
            x.put(tmp, x.get(tmp) + 1);
        if (!m.contains(tmp))
            m.add(tmp);
    }

    for (int i = 0; i < m.size(); i++)
        System.out.println(m.get(i) + " occured " + x.get(m.get(i)) + " times");

}