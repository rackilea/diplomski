outer:
for (int i = 0; i < words.length; i++) {

    repeats[i] = 1;
    for(int index = i-1; index >= 0; index--) {
        if(words[i].equals(words[index])) {
            continue outer;
        }
    }
    ...
}