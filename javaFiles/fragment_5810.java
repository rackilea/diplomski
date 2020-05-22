fun getToken(loginManager: LoginManager): String {
return Single
        .create(SingleOnSubscribe<String> { emitter ->
            loginManager.getToken(object : TokenSimpleCallback {
                override fun onSuccess(token: String) {
                    emitter.onSuccess(token)
                }

                override fun onFailure(loginServiceError: LoginServiceError) {
                    emitter.onError(Throwable(loginServiceError.toString()))
                }
            })
        }).blockingGet()}