public static void main(String[] args) {
        Integer[] a = new Integer[] { 1, 0, 0, 1, 0, 0 };
        List<Integer> a1 = Arrays.asList(a);
        Integer[] b = new Integer[] { 0, 1, 1, 0, 0, 0 };
        List<Integer> a2 = Arrays.asList(b);
        List<Integer> a3 = new ArrayList();
        for (int i = 0; i < a1.size(); i++) {
            a3.add(a1.get(i) | a2.get(i));
            System.out.print(a3.get(i));
        }
    }