...
public static OpenSSLLib libSSL;
public static LibEayLib  libEay;
...

static {
    libSSL = OpenSSLLib.INSTANCE;
    libEay = LibEayLib.INSTANCE;
    libSSL.SSL_library_init();
    libEay.OPENSSL_add_all_algorithms_conf(); // This function is called from                                              
                                              // libeay32.dll via another JNA interface.
    libSSL.SSL_load_error_strings();
}