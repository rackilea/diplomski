class Player {
    abstract String greet();
}

class EnglishPlayer extends Player {
    String greet() {
        return "Hello";
    }
}

class JapanesePlayer extends Player {
    String greet() {
        return "Konnichi wa";
    }
}