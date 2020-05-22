final int minNumber = 1;
final int maxNumber = 100;
final int numbersToGenerate = 3;

final int[] ints = new Random().ints(minNumber, maxNumber)
.distinct().limit(numbersToGenerate).toArray();

List<Integer> possibleAnswers = asList(ints);
possibleAnswers.add(correctAnswerIndex);
Collections.shuffle(possibleAnswers, new Random(System.nanoTime()));