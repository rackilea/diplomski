private void setPosition(int index) {
    List<String> positionData = obj.get(index);
    textArea.setText(positionData.get(0));
    textArea1.setText(positionData.get(1));
    textArea2.setText(positionData.get(2));
    textArea3.setText(positionData.get(3));
    textArea4.setText(positionData.get(4));
    mediaPlayerComponent.getMediaPlayer().setPosition(Float.parseFloat(positionData.get(5)));
    mediaPlayerComponent2.getMediaPlayer().setPosition(Float.parseFloat(positionData.get(6)));
}