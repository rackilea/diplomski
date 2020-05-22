int k = 8421753;
ArrayList<Integer> digits = new ArrayList<>();
while (k > 0) {
    digits.add(k % 10);
    k /= 10;
}
Collections.sort(digits);
System.out.println(digits); // [1, 2, 3, 4, 5, 7, 8]