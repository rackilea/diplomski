class ToTest {

    private IdEncryptor encryptor;

    public ToTest(IdEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    public String produceResponse(String input) {
        String[] encryptedIds = encryptor.encryptIds(input);
        return doStuff(input, encryptedIds);
    }
}