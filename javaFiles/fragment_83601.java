List<Integer> numberStars = new ArrayList<Integer>();
int counter = 0;
while (file.hasNext()) {
    String contents = file.next();
    if (contents.contains("*")) {
        numbStars.add(counter);
        continue;
    }
    counter++;
}
numberStars.remove(numberStars.size() - 1); // remove last value
// all the values are now available in the numberStars list