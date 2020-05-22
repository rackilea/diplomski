RSAKeyParameters pubParameters = new RSAKeyParameters(false, mod3, pub3);
RSAKeyParameters privParameters = new RSAKeyParameters(true, mod3, pri3);
RSAEngine rsa = new RSAEngine();
byte[] data;
ISO9796d2Signer eng = new ISO9796d2Signer(rsa, new RIPEMD128Digest());
eng.init(true, privParameters);
eng.update(msg4[0]);
eng.update(msg4, 1, msg4.length - 1);
data = eng.generateSignature();
eng.init(false, pubParameters);
eng.update(msg4[0]);
eng.update(msg4, 1, msg4.length - 1);
if (eng.hasFullMessage()) {
    eng = new ISO9796d2Signer(rsa, new RIPEMD128Digest());
    eng.init(false, pubParameters);
    if (!eng.verifySignature(sig4)) {
        // signature tampered with
    }
    byte[] message = eng.getRecoveredMessage(), 0, msg4);
}