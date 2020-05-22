public class EncryptionAwareDataSource extends BasicDataSource{
    @Override
    public synchronized void setPassword(String password) {     
        super.setPassword(Encryptor.getDecryptedValue( password ));
    }
}