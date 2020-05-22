List<String> provinces = Arrays.asList("New Brunswick", "Saskatchewan", "Ontario", "Nova Scotia", "Quebec", "Alberta");

List<Integer> indexes = new ArrayList<>();
for (int i = 0; i < provinces.size(); i++)
    if (! provinces.get(i).equals("Saskatchewan"))
        indexes.add(i);
Collections.shuffle(indexes);

StringBuilder outputAnswers = new StringBuilder();
for (int i : indexes)
    outputAnswers.append(provinces.get(i) + "\n");

System.out.print(outputAnswers);