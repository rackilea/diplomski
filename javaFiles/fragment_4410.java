List<Float> numbers = new ArrayList<Float>();
...
numbers.add(Float.parseFloat(userInput));
...
for (float n : numbers) {
    sum += n;
}
average = sum / numbers.size();  // Note: Don't even need a count variable