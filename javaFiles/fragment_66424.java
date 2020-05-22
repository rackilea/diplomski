@TargetApi(21)
private fun getMobileNetWork() {
    connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val builder = NetworkRequest.Builder()
    builder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)//TRANSPORT_WIFI
    val build = builder.build()
    connectivityManager!!.requestNetwork(build, networkCallback)
}


val networkCallback = object : ConnectivityManager.NetworkCallback() {
    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        //Use the network to do your thing
    }

    override fun onLost(network: Network?) {
        super.onLost(network)
    }
    override fun onUnavailable() {
        super.onUnavailable()
    }
}