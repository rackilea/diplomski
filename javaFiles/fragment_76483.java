String word = "DOG";
int position = 0;

public String nextClick() {
    if (word != null && position < word.length()) {
        position++;
        return word.substring(position-1, position);
    }
    return "";
}