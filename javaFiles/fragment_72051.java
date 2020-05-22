object ConstantsWrapper {
  private val cls = classOf[TextToSpeech#Engine]
  def apply(fieldName: String) = cls.getDeclaredField(fieldName).get(null)
                                    .toString

  val CHECK_VOICE_DATA_PASS = apply("CHECK_VOICE_DATA_PASS")
  // Insert more here
}

if (resultCode == ConstantsWrapper.CHECK_VOICE_DATA_PASS) {
  mTts = new TextToSpeech(this, mTtsListener)
}