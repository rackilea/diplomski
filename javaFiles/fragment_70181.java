Set winningNums = new TreeSet();
Random rand = new Random();

while (winningNums.size() < 6) {
    winningNums.add(rand.nextInt(51));
}

System.out.println(winningNums.toString());