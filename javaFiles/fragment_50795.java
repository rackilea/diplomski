Emptylambda outer@ {
     container[String(), Any(), Any()] inner@ {  // <--- add label here
        val myCondition = true
        if (myCondition) return@inner            // <--- exits from lambda 

        print(it)
    }
}