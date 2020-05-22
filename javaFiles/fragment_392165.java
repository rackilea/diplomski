for (int i = 0; i < num - 1; i++) {
    String thisLast = "";
    if (sentence[i].compareTo(sentence[i + 1]) > 0) {
        thisLast = sentence[i];
        count++;
    } else if (sentence[i].compareTo(sentence[i + 1]) < 0) {
        thisLast = sentence[i + 1];
        count++;
    }

    if (thisLast.compareTo(last) > 0)
        last = thisLast;

}