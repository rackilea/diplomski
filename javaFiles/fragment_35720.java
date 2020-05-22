import java.io.*;

public class SignedTimestamp implements Serializable {
    private Long obj;
    private byte[] signature;
    private String signatureAsAString;

    public SignedTimestamp(Long obj, byte[] signature, String signatureAsAString) {
        this.obj = obj;
        this.signature = signature;
        this.signatureAsAString = signatureAsAString;
    }

    public Long getObj() {
        return this.obj;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public String getSignatureAsAString() {
        return this.signatureAsAString;
    }

}