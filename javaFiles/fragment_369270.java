char *plain_text = apr_pstrdup(pool, "some value");
char *passphrase = apr_pstrdup(pool, "some pass");

const int salt_len = 9;
const char salt_in[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};

const int iterations = 1000;

// everything after the 16th byte is ignored for AES 128
const int iv_len = 16;
const char iv_in[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

unsigned char *cipher_text = NULL;
apr_size_t cipher_text_len = 0;
apr_size_t block_size = 0;
apr_size_t iv_size = 0;

const apr_crypto_driver_t *driver = get_openssl_driver(r, pool);
apr_crypto_t *f1 = factory(pool, driver);

char *salt = apr_palloc(pool, salt_len);
memcpy(salt, salt_in, salt_len);

apr_crypto_key_t *crypto_key = NULL; // init to NULL is important, see docs!

apr_crypto_passphrase(&crypto_key, &iv_size, passphrase, strlen(passphrase), salt, salt_len, APR_KEY_AES_128, APR_MODE_CBC, 1, iterations, f1, pool);

unsigned char *iv = apr_palloc(pool, iv_len);
memcpy(iv, iv_in, iv_len);

encrypt_block(NULL, pool, driver, f1, crypto_key, plain_text, strlen(plain_text),
                           &cipher_text, &cipher_text_len, &iv, &block_size, "KEY_AES_128/MODE_CBC");

// Note: b64_len includes spaces for '\0' terminator
int b64_len = apr_base64_encode_len(cipher_text_len);
char *b64 = apr_pcalloc(pool, b64_len);
apr_base64_encode_binary(b64, cipher_text, cipher_text_len);