public class SSLEndpoint {
  public Pointer context; // SSL_CTX*
  public Pointer ssl;     // SSL*
  ...
}

...

SSLEndpoint endpoint = new SSLEndpoint();     

...

// Use one of supported SSL/TLS methods; here is the example for TLSv1 Method
endpoint.context = libSSL.SSL_CTX_new(libSSL.TLSv1_method());

if(endpoint.context.equals(Pointer.NULL)) {
  throw new SSLGeneralException("Failed to create SSL Context!");
}

int res = libSSL.SSL_CTX_set_cipher_list(endpoint.context, OpenSSLLib.DEFAULT_CIPHER_LIST);
if(res != 1) {
  throw new SSLGeneralException("Failed to set the default cipher list!");
}

libSSL.SSL_CTX_set_verify(endpoint.context, OpenSSLLib.SSL_VERIFY_NONE, Pointer.NULL);

// pathToCert is a String object, which defines a path to a cerificate
// in PEM format. 
res = libSSL.SSL_CTX_use_certificate_file(endpoint.context, pathToCert, certKeyTypeToX509Const(certType));
if(res != 1) {
  throw new SSLGeneralException("Failed to load the cert file " + pathToCert);
}

// pathToKey is a String object, which defines a path to a priv. key
// in PEM format.
res = libSSL.SSL_CTX_use_PrivateKey_file(endpoint.context, pathToKey, certKeyTypeToX509Const(keyType));
if(res != 1) {
  throw new SSLGeneralException("Failed to load the private key file " + pathToKey);
}

res = libSSL.SSL_CTX_check_private_key(endpoint.context);
if(res != 1) {
  throw new SSLGeneralException("Given key " + pathToKey + " seems to be not valid.");
}