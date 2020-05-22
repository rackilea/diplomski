public static void main(String[] args) {
    Welcome.greet();
    Game start = new Game();
    start.inputName();
    Welcome.greetPlayer(start);
    start.show();
}