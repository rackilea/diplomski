class AwsEncryptionSDKWrapper(private val keyIdArn: String, region: String) {
    private val crypto = AwsCrypto()
    private val prov: KmsMasterKeyProvider = KmsMasterKeyProvider.builder().withDefaultRegion(region).withKeysForEncryption(keyIdArn).build()

    fun encrypt(raw: String, encryptionContext: Map<String, String>): String {
        return crypto.encryptString(prov, raw, encryptionContext).result
    }

    fun decrypt(cipherText: String, encryptionContext: Map<String, String>): String {
        val decryptedResponse = crypto.decryptString(prov, cipherText)
        if (decryptedResponse.masterKeyIds[0] != keyIdArn) {
            throw IllegalStateException("Wrong key ID!")
        }

        encryptionContext.entries.forEach { (key, value) ->
            if (value != decryptedResponse.encryptionContext[key]) {
                throw IllegalStateException("Wrong Encryption Context!")
            }
        }
        return decryptedResponse.result
    }
}

class AwsKMSSDKWrapper(region: String) {
    private val client = AWSKMSClientBuilder.standard().withRegion(region).build()

    fun encrypt(keyIdArn: String, raw: String, encryptionContext: Map<String, String>): String {
        val plaintextBytes = raw.toByteArray(StandardCharsets.UTF_8)

        val encReq = EncryptRequest()
        encReq.keyId = keyIdArn
        encReq.plaintext = ByteBuffer.wrap(plaintextBytes)
        encReq.withEncryptionContext(encryptionContext)
        val cipherText = client.encrypt(encReq).ciphertextBlob

        return Base64.getEncoder().encodeToString(cipherText.array())
    }

    fun decrypt(base64CipherText: String, encryptionContext: Map<String, String>, keyIdArn: String): String {
        val req = DecryptRequest()
            .withCiphertextBlob(ByteBuffer.wrap(Base64.getDecoder().decode(base64CipherText)))
            .withEncryptionContext(encryptionContext)

        val resp = client.decrypt(req)
        if (resp.keyId == null || resp.keyId!!.contentEquals(keyIdArn))  throw IllegalStateException("keyid not match ! provided $keyIdArn, actual ${resp.keyId}");

        return resp.plaintext.array().toString(StandardCharsets.UTF_8)
    }
}