private fun sendBackResult(resultFile: File?) {
    val fileUri = Uri.fromFile(resultFile)
    val dataIntent = Intent()
    dataIntent.data = fileUri
    dataIntent.putExtra("isFront", isFrontCamera)
    activity!!.setResult(Activity.RESULT_OK, dataIntent)
    activity!!.finish()
}