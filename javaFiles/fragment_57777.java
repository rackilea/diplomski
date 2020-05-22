String smallest = null;

for (int i = 0; i < words.length; i++) {
    if (i == 0) {
        smallest = words[i];
    } else if (words[i].compareTo(smallest) < 0) {
        smallest = words[i]
    }
}

System.out.println(smallest);