import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface OpenSSLLib extends Library {
  public OpenSSLLib INSTANCE = (OpenSSLLib) Native.loadLibrary("ssleay32",
                               OpenSSLLib.class);
  // Non-re-enterable! Should be called once per a thread (process).
  public void SSL_library_init();
  public void SSL_load_error_strings();

  // Supported context methods.
  public Pointer TLSv1_method();

  ...

  // Context-related methods.
  public Pointer SSL_CTX_new(Pointer method);
  public void SSL_CTX_free(Pointer context);
  public int SSL_CTX_use_PrivateKey_file(Pointer context, String filePath, int type);
  public int SSL_CTX_use_certificate_file(Pointer context, String filePath, int type);
  public int SSL_CTX_check_private_key(Pointer context);
  public int SSL_CTX_ctrl(Pointer context, int cmd, int larg, Pointer arg);
  public void SSL_CTX_set_verify(Pointer context, int mode, Pointer verifyCallback);
  public int SSL_CTX_set_cipher_list(Pointer context, String cipherList);

  public Pointer SSL_new(Pointer context);
  public void SSL_free(Pointer ssl);

  ...
}