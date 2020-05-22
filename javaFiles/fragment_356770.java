fun main(args: Array<String>) {
    val urlPath = "https://google.com"
    try {
        (URL(urlPath).openConnection() as HttpsURLConnection).apply {
            sslSocketFactory = createSocketFactory(listOf("TLSv1.2"))
            hostnameVerifier = HostnameVerifier { _, _ -> true }
            readTimeout = 5_000
        }.inputStream.use {
            it.copyTo(System.out)
        }
    } catch (e: Exception) {
        TODO()
    }
}


private fun createSocketFactory(protocols: List<String>) =
    SSLContext.getInstance(protocols[0]).apply {
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
            override fun checkClientTrusted(certs: Array<X509Certificate>, authType: String) = Unit
            override fun checkServerTrusted(certs: Array<X509Certificate>, authType: String) = Unit
        })
        init(null, trustAllCerts, SecureRandom())
    }.socketFactory