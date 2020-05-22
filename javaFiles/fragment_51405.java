index = randomGenerator.nextInt(list.size());
    element = list.get(index);
    String[] bits = element.split(" ");
    element = bits[bits.length-1];
    while (element.length() < 6 || element.length() > 8) {
         index = randomGenerator.nextInt(list.size());
         element = list.get(index);
         bits = element.split(" ");
         element = bits[bits.length-1];
    }