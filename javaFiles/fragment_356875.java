.subscribe(object: Observer<String>(){
    override fun onComplete() {
        TODO("not implemented")
    }

    override fun onSubscribe(s: Disposable?) {
        TODO("not implemented")
    }

    override fun onError(e: Throwable?) {
        //TODO : Handle error here
    }

    override fun onNext(t: String?) {
        Log.e("Output",t);
    }
})