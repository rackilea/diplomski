public bool isWriteable(char c){
    if (this.x == null){
        return c == this.ch;
    else {
        return this.ch == c && this.x.isWriteable(c);
    }
}