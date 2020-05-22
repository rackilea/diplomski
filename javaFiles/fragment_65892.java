fun startMessageRetrieveRequest(callback: OnRequestFinishedListener<List<MessageReceivedResponseModel>>){
    doAsync {
        Thread.sleep(1000)
        val idx = Random().nextInt(2)
        val its: List<MessageReceivedResponseModel>
        when(idx){
            0 -> its = REs
            1 -> its = RES_1
            else -> its = RES_1
        }
        callback.onResponse(its)
    }
}