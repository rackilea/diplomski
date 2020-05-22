Thread anotherProgram = new Thread(new Runnable() {
    @Override
    public void run() {
        AnotherClass.main(new String[]{"foo","bar"});
    }
});
anotherProgram.start();