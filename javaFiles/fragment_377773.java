public static String encryptMessage(String message, String salt) {
            String encMessage = message;
            byte[] encVal = null;
            String messageWithSalt = null;
            try {
                Key key = generateKey();

                Cipher c = Cipher.getInstance(ALGORITHM);
                c.init(Cipher.ENCRYPT_MODE, key);

                for (int i = 0; i < ITERATIONS; i++) {
                    messageWithSalt = salt + encMessage;
                    encVal = c.doFinal(messageWithSalt.getBytes());
                    byte[] encryptedValue = new Base64().encode(encVal);
                    encMessage = new String(encryptedValue);
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
            return encMessage;
        }