List<String> part1 = new ArrayList<>();//create a list for the part 1
List<String> part2 = new ArrayList<>();//create a list for the part 2

while ((readLine = b.readLine()) != null) {
    String[] parts = readLine.split("/");//you mean to split with '/' not with '-'

    part1.add(parts[0]);//put the first part in ths list part1
    part2.add(parts[1]);//put the second part in ths list part2
}