// init and gen key
HCRYPTPROV provider;
CryptAcquireContext(&provider, NULL, MS_ENH_RSA_AES_PROV, PROV_RSA_AES, CRYPT_VERIFYCONTEXT);

// Use symmetric key encryption
HCRYPTKEY sessionKey;
DWORD exportKeyLen;
BYTE iv[32];
memset(iv, 0, sizeof(iv));
DWORD padding = PKCS5_PADDING;
DWORD mode = CRYPT_MODE_CBC;
CryptGenKey(provider, CALG_AES_128, CRYPT_EXPORTABLE, &sessionKey);
CryptSetKeyParam(sessionKey, KP_IV, iv, 0);
CryptSetKeyParam(sessionKey, KP_PADDING, (BYTE*)&padding, 0);
CryptSetKeyParam(sessionKey, KP_MODE, (BYTE*)&mode, 0);

// Export key
BYTE exportKey[1024];
CryptExportKey(sessionKey, NULL, PLAINTEXTKEYBLOB, 0, exportKey, &exportKeyLen);

// skip PLAINTEXTKEYBLOB header
//      { uint8_t bType, uint8_t version, uint16_t reserved, uint32_t aiKey, uint32_t keySize }
DWORD keySize =  *((DWORD*)(exportKey + 8));
BYTE * rawKey = exportKey + 12;

// Encrypt message
BYTE encryptedMessage[1024];
const char * message = "Decryption Works -- using multiple blocks";
BYTE messageLen = (BYTE)strlen(message);
memcpy(encryptedMessage, message, messageLen);
DWORD encryptedMessageLen = messageLen;
CryptEncrypt(sessionKey, NULL, TRUE, 0, encryptedMessage, &encryptedMessageLen, sizeof(encryptedMessage));

BYTE byteEncryptedMessageLen = (BYTE)encryptedMessageLen;
FILE * f = fopen("test.aes", "wb");
fwrite(rawKey, 1, keySize, f);
fwrite(&byteEncryptedMessageLen, 1, sizeof(byteEncryptedMessageLen), f);
fwrite(encryptedMessage, 1, encryptedMessageLen, f);
fclose(f);

// destroy session key
CryptDestroyKey(sessionKey);
CryptReleaseContext(provider, 0);