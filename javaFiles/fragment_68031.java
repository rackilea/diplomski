/**
 * Load or generate a RSA keypair to use as a client for the given JSch.
 */
public boolean registerKeyPair(JSch jSch) {             
    new File(getRootFolder().getAbsolutePath() + "/.ssh").mkdirs();

    File privateKey = new File(getRootFolder().getAbsolutePath() + "/.ssh/id_rsa");
    File publicKey = new File(getRootFolder().getAbsolutePath() + "/.ssh/id_rsa.pub");
    if (!privateKey.exists() || !publicKey.exists()) {          
        try {
            KeyPair keyPair = KeyPair.genKeyPair(jSch, KeyPair.RSA);
            keyPair.writePrivateKey(privateKey.getAbsolutePath());
            keyPair.writePublicKey(publicKey.getAbsolutePath(), "Machine Shop");
            return true;
        } catch (JSchException e) {
            Log.e("genKeyPair(RSA)", Log.getStackTraceString(e));
        } catch (FileNotFoundException e) {
            Log.e("genKeyPair(RSA)", Log.getStackTraceString(e));
        } catch (IOException e) {
            Log.e("genKeyPair(RSA)", Log.getStackTraceString(e));
        }
        return false;           
    }       

    try {
        jSch.addIdentity(privateKey.getAbsolutePath());
        return true;
    } catch (JSchException e) {
        Log.w("jSch.addIdentity", Log.getStackTraceString(e));
        return false;           
    }

}