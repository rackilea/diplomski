int compareTo(Foo f) {
    int x = letter.compareTo(f.letter);
    return x != 0 ? x 
         : letter.equals("A") ? number.compareTo(f.number)
                              : f.number.compareTo(number);
}