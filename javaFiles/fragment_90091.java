List<String> words;
for (int i=0; i < words.size(); ++i) {
    if (i % 10 > 0) {
        System.out.print(" ");
    }
    System.out.print(words.get(i));
    if ((i+1) % 10 == 0) {
        System.out.println("");     // print correct newline regardless of OS
    }
}