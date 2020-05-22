install(ContentNegotiation) {
    gson {
        setPrettyPrinting()
        registerTypeAdapter(PublicKey::class.java, JsonDeserializer<PublicKey> { json, _, _ ->
            // TODO some type checking.
            val key = json.asString
            val encryptedKey = Base64.getDecoder().decode(key.split(" ")[1])
            val inputStream = DataInputStream(ByteArrayInputStream(encryptedKey))

            val format = String(ByteArray(inputStream.readInt()).also(inputStream::readFully))

            if (format != "ssh-rsa") throw RuntimeException("Unsupported format")

            val publicExponent = ByteArray(inputStream.readInt()).also(inputStream::readFully)
            val modulus = ByteArray(inputStream.readInt()).also(inputStream::readFully)

            val spec = RSAPublicKeySpec(BigInteger(modulus), BigInteger(publicExponent))
            val keyFactory = KeyFactory.getInstance("RSA")

            keyFactory.generatePublic(spec)
        })
    }
}