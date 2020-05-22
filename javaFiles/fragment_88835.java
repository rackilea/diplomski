ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
ArrayList<Integer> usedQuestions = new ArrayList<Integer>();
for (int i = 0; i < 3; i++) // add 0, 1, 2
    usedNumbers.add(i);

usedQuestions = usedNumbers;
usedNumbers.remove(0);
System.out.println(usedQuestions);