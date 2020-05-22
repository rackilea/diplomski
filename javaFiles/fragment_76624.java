@Override
public boolean equals(Object wordtoCompare) {
    boolean flag = false;
    if(wordtoCompare == this) return true;
    if(!(wordtoCompare instanceof Word)) return false;
    Word word = (Word)wordtoCompare;

    this.compareTo(word);
    // Whatever you do with your flag
    return flag;
}