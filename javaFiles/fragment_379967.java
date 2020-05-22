String[] Array1 = new String[]{"4", "+", "5", "-", "3"};
List<Integer> Array2 = new ArrayList<Integer>();
for (int n = 0; n < Array1.length; n += 2) {
      // look out ^
      Array2.add(Integer.parseInt(Array1[n]));
}