private fun asyncCall(n : Int) {
    doAsync {
        try {
            uiThread {
                toast("streamJSON call")
            }

            // Call API, store Place objects in placesList
            placesList = streamJSON()
        } catch (e: java.lang.RuntimeException) {
            uiThread {
                toast("Invalid Request")
            }
        }

        uiThread {
            if(n == 1) { // Submit button
                goToResults()
            } else if (n == 2) { // Feeling lucky button
                feelingLuckyAlert()
            }
        }
    }
}