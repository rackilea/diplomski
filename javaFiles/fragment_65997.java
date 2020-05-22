List<Pair<Integer,String>> mPairs = new ArrayList<>();
Scanner input = new Scanner(System.in);

for (int c = 0; c < 3; c++) {
    String one = input.next();
    String two = input.next();
    mPairs.add(new Pair<>(Integer.valueOf(one), two));
}

mPairs.sort(Comparator.comparing(Pair::getKey));
mPairs.forEach(p -> System.out.println(p.getValue()));