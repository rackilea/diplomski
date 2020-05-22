DateTime now = DateTime.now();
DateTime start = now;
DateTime stop = now.plusDays(10);
DateTime inter = start;
// Loop through each day in the span
while (inter.compareTo(stop) < 0) {
    System.out.println(inter);
    // Go to next
    inter = inter.plusDays(1);
}