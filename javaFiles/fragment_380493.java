import java.io.File;
import java.security.KeyStore;
import java.security.Provider;
import java.util.Enumeration;

public class KeyStoreCallbackSample {

    public static void main(String args[]) throws Exception {
        // instantiate a keystore to get the provider for specific type
        KeyStore ks = KeyStore.getInstance("JKS");

        // create the callback handler to get the password
        KeyStore.CallbackHandlerProtection cbhp = new KeyStore.CallbackHandlerProtection(new YourImplementationCallbackHander());
        // create the builder passing keystoreType, provider, keystore file, and callbackhandler
        KeyStore.Builder builder = KeyStore.Builder.newInstance("JKS", ks.getProvider(), new File("/path/YourKeyStore.jks"), cbhp);
        // create the keystore
        ks = builder.getKeyStore();

        // print the keystores alias to check if all it's load correctly
        Enumeration<String> aliases = ks.aliases();
        while(aliases.hasMoreElements()){
            System.out.println(aliases.nextElement());
        }       
    }
}