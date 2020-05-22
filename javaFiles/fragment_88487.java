if (action.equalsIgnoreCase("xxxxxxxxxxxxxxxxx")) {
    HashMap<String, String> hashTts = new HashMap<String, String>();
    hashTts.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "id");

    String playing = "test string";
    tts.synthesizeToFile(playing, hashTts, storagePath + "/" + "tst.wav");
}