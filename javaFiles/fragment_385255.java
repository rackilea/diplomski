request.enqueue(CallbackWrapper<RegisterResponse>(object : CallbackWrapper.Wrapper<RegisterResponse> {
        override fun onResult(throwable: Throwable?, response: Response<RegisterResponse>?) {
            response?.let { callBack.onResponse(response.body() ?: RegisterResponse()) }
            throwable?.let { callBack.onFailure(throwable.message!!) }
        }
    }))