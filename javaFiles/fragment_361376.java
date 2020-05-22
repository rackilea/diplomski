public SecretKey key;

public char[] password = "1234567890".toCharArray();

void GenerateKey(){
    try {
        // Get and Convert the Key
        key = KeyGenerator.getInstance("AES").generateKey();

        SaveKey();
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}

void SaveKey(){
    try{
        // Save my secret key
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(key);
        ks.setEntry("SecretKeyAlias", secretKeyEntry,null);

        // Save the keystore
        FileOutputStream fos = new FileOutputStream(this.getFilesDir().getAbsolutePath() + "/OEKeyStore");
        ks.store(fos, password);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}

void LoadKey(){
    try{
        // Load Keystore
        FileInputStream fis = new FileInputStream(this.getFilesDir().getAbsolutePath() + "/OEKeyStore");
        ks.load(fis, password);

        // Load the secret key
        KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry)ks.getEntry("SecretKeyAlias",null);
        key = secretKeyEntry.getSecretKey();
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}