private void TextOutputWrapper (String outputText) {
    Message msg = new Message();
    Bundle bndle = new Bundle();
    bndle.putString("Output", "\n" + outputText);
    msg.setData(bndle);
    textFromBGThread.sendMessage(msg);
}