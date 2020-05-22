import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

public class Base64test {

    public static void main(String[] args) {
        String SAML_resp = "<SAML RESP>";
        byte[] decoded = DatatypeConverter.parseBase64Binary(SAML_token);
        try {
            System.out.println(new String(decoded, "UTF-8"));
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
    }
}