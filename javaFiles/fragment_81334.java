Random random = new Random(seed);
int count = 200; // or another number, just how many you need
List<Float> numbers = new ArrayList<Float>(count);
for (int i = 0; i < count; i++) {
    numbers.add(random.nextFloat() + (i % 4));
}
Collections.shuffle(numbers);