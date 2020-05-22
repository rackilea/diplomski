double largest = a.nextDouble();
double smallest = largest;
while (a.hasNextDouble()) {
    double input = a.nextDouble();
    largest = Math.max(largest, input);
    smallest = Math.min(smallest, input);
}