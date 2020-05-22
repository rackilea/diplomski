public FunnyInterface calculateSomething() {
    try {
        return builder.someFunnyInterface(); // throws Exception
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}