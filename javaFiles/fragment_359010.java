override fun finishAfterTransition() {
    val data = Intent()
    data.putExtra("KEY_FROM_ACTIVITY_2", 42) // `42` is the original position that we passed to this activity via Intent when launching it
    setResult(RESULT_OK, data)
    super.finishAfterTransition()
}