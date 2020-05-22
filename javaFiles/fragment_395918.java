private static Queue<String> results = new ConcurrentLinkedQueue<String>();

@Test
public void test() throws InterruptedException {

    String plainText = "some text to verify data integrity";

    String encryptedText = Encrypt.encrypt(plainText);


    for (int i = 0; i < 5000; i++) {

        new Thread( () -> { results.add(Decrypt.decrypt(encryptedText)); })
        .start();;          
    }

    Thread.sleep(5000);

    assertTrue(results.size() == 5000);

    while(!results.isEmpty()) {

        assertTrue(results.poll().equals(plainText));
    }
}