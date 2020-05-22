Random generator = new Random();
final int MIN = 0, MAX = 100;
LinkedList<Integer> numberLine = new LinkedList<>();

for (int count = 1; count <= 10; count++) {
    int random = generator.nextInt(MAX) + 1;
    numberLine.add(random);
}

int last = numberLine.getLast();
int first = numberLine.getFirst();
int max = Collections.max(numberLine);
int min = Collections.min(numberLine);