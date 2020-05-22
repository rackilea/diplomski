class Poo {
    private var completeData: String? = null

    var data: String
        get() = completeData?.substring(0, 4) ?: ""
        set(value) { completeData = value }

    val dataPart2: String
        get() = completeData?.substring(4) ?: ""
}