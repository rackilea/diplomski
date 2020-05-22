private fun debounce(yourParams: Any, delayMillis: Long) {
        handler.removeCallbacks(runnable)
        runnable = Runnable {
            // Your code here.
        }
        handler.postDelayed(runnable, delayMillis)
    }