async {
    try {
        val s1 = await(future1)
        val s2 = await(future2)
        println(s1 + s2)
    } catch (e: Exception) {
        println("failed")
    }
}