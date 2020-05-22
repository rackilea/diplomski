import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.StringRefAddr;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptedDataSourceFactory extends BasicDataSourceFactory {

    private String USERNAME_TAG = "username";

    private String PASSWORD_TAG = "password";

    private String URL_TAG = "url";

    private StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

    private String password = System.getenv("secret-key");

    public EncryptedDataSourceFactory() {
        encryptor.setPassword(this.password);
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context ctx, Hashtable env) throws Exception {
        if (obj instanceof Reference) {
            setUsername((Reference) obj);
            setPassword((Reference) obj);
            setURL((Reference) obj);
        }
        return super.getObjectInstance(obj, name, ctx, env);
    }

    private void setUsername(Reference ref) {
        findDecryptAndReplace(USERNAME_TAG, ref);
    }

    private void setPassword(Reference ref) {
        findDecryptAndReplace(PASSWORD_TAG, ref);
    }

    private void setURL(Reference ref) {
        findDecryptAndReplace(URL_TAG, ref);
    }

    private void findDecryptAndReplace(String refType, Reference ref) {
        Integer idx = find(refType, ref);
        if (idx == null) {
            System.out.println("The \"" + refType + "\" name/value pair was not found"
                    + " in the Reference object.  The reference Object is" + " " + ref.toString());
        } else {
            String decrypted = decrypt(ref.get(refType).getContent().toString());
            replace(idx, refType, decrypted, ref);
        }
    }

    private void replace(int idx, String refType, String newValue, Reference ref) {
        ref.remove(idx);
        ref.add(idx, new StringRefAddr(refType, newValue));
    }

    private String decrypt(String input) {
        return encryptor.decrypt(input);
    }

    private Integer find(String addrType, Reference ref) {
        Integer index = null;
        Enumeration<RefAddr> enu = ref.getAll();
        for (int i = 0; enu.hasMoreElements(); i++) {
            RefAddr addr = (RefAddr) enu.nextElement();
            if (addr.getType().compareTo(addrType) == 0)
                index = i;
        }
        return index;
    }
}