SayHello sh = new SayHello() {
    @Override
    public void speak(String message) {
        System.out.println("Hello " + message);
    }
};

names.forEach(n -> sh.speak(n));