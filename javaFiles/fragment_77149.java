// Consumer<String> consumer = s -> s.isEmpty();
Consumer<String> consumer = new Consumer<String>() {
    @Override
    public void accept(String s) {
        s.isEmpty(); // treated as void here 
    }
};