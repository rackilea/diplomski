List<Integer> l1 = new ArrayList<Integer>();
List<Integer> l2 = new ArrayList<Integer>();

Scanner s = new Scanner(new FileReader("filename.txt"));

while (s.hasNext()) {
    l1.add(s.nextInt());
    l2.add(s.nextInt());
}

s.close();

System.out.println(l1);  // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
System.out.println(l2);  // [12, 15, 6, 4, 3, 6, 12, 8, 8, 9, 13]