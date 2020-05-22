public static void main(String[] args) {
    int a = 0;
    Consumer<String> stringConsumer = foo -> {
      foo += a;
    };

    for (int i = 0; i < 1; i++) {
        String s = " " + a;
    }
}