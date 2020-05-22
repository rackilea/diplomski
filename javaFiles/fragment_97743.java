try {
        String test = encrypt("My name is Nam");
        Log.e("TEST", "xxxx encrypted: "+ test);
        Log.e("TEST", "xxxx decrypted: "+ decrypt(test));
    } catch (Exception e) {
        e.printStackTrace();
    }