try {
            AESCrypter _crypt = new AESCrypter("password");
            String output = "";
            String plainText = "top secret message";
            output = _crypt.encrypt(plainText); //encrypt
            System.out.println("encrypted text=" + output);
            output = _crypt.decrypt(output); //decrypt
            System.out.println("decrypted text=" + output);
        } catch (Exception e) {
            e.printStackTrace();
        }