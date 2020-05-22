while (in.hasNext()) {
    String word = in.next();
    if (word.equals("exit")) {
        break;
    }
    double totalchar = word.length();
    sum = totalchar + sum;
    counter++;
}
double average = 0;
if (counter > 0) {
    average = sum / counter;
}
System.out.println(average);