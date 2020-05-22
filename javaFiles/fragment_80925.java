final int maxNumber = 100;
final int numbersToGenerate = 4;
final int correctAnswer = 45;

Set<Integer> possibleAnswers = new HashSet<>();
Random random = new Random();

// add correct answer
possibleAnswers.add(correctAnswer);

// add as much random answers as needed, the usage of a set prevents duplicates
while(possibleAnswers.size() < numbersToGenerate) {
    possibleAnswers.add(random.nextInt(maxNumber));
}

// convert set to list and shuffle it
List<Integer> answers = new ArrayList<Integer>(possibleAnswers);
Collections.shuffle(answers, new Random(System.nanoTime()));