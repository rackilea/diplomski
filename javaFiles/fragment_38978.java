public String empty() {
    String stackWord = "";
    while (this.first != null)
        stackWord += this.pop();
    return stackWord;
}