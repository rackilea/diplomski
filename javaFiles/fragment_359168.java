Time[] times = new Time[array.length / 2 + 1];
// List<Time> times = new ArrayList<>(array.length / 2 + 1);

for (int i =0; i < array.length; i += 2) {
    times[i] = new Time(array[i]);
    // times.add(new Time(array[i]));
}