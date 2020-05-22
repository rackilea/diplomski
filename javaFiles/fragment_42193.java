public PasswordRandomizer(int length) {
    // Initialize the variable
    password = "";
    this.length = length;
    while (this.password.length() < this.length) {
        this.symbol = "abcdefghijklmnopqrstuvwxyz".charAt(this.random.nextInt(25));
        this.password += symbol;
    }
}