Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(appId)
                .clientKey("")
                .server(serverUrl)
                .addNetworkInterceptor(new ParseLogInterceptor())
                .build()
        );