@Override
    public SimpleMeter testEncryption(File baseInput, String algorithm, String provider) throws NoSuchProviderException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipherEncryption;

        SimpleMeter meter = new SimpleMeter();

        SecureRandom randGenerator = new SecureRandom();
        KeyGenerator generator;

        generator = KeyGenerator.getInstance(algorithm.split("/")[0], provider);
        generator.init(randGenerator);
        SecretKey key = generator.generateKey();

        cipherEncryption = Cipher.getInstance(algorithm, provider);
        cipherEncryption.init(Cipher.ENCRYPT_MODE, key);

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(baseInput))) {

            CipherInputStream encryptionStream = new CipherInputStream(input, cipherEncryption);

            meter.start();

            while (encryptionStream.read() > -1);

            encryptionStream.close();//End all encryption and decryption operation

            meter.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
            meter = null;
        }

        return meter;
    }