val builder = OkHttpClient.Builder()
            .connectTimeout(15L, TimeUnit.SECONDS)
            .readTimeout(20L, TimeUnit.SECONDS)
            .writeTimeout(15L, TimeUnit.SECONDS)
            .socketFactory(network.socketFactory)
            .dns {
                network.getAllByName(it).asList()
            }