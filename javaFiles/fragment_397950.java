val sec2 = 10L
    val counting: CountDownTimer =
        object : CountDownTimer(TimeUnit.SECONDS.toMillis(sec2), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.i("alarm rings in", (millisUntilFinished / 1000).toString())
            }

            override fun onFinish() {
                Log.i("alarm done", "alarm is ringing")
            }
        }

    counting.start()