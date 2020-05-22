String[] words = line.split(" ");
for(int i = 0; i < words.length; i++) {
    System.out.print(words[i]);
    if ((i + 1) % 3 != 0) {
        System.out.print(" ");
    } else {
        System.out.println();
    }
}