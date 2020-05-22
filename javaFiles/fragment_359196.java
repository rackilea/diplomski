private List<byte[]> rescievedBytes=new ArrayList<>();
@Override
public void handleCombinedAudio(CombinedAudio combinedAudio) {
    try {
        rescievedBytes.add(combinedAudio.getAudioData(VOLUME));
    }catch (OutOfMemoryError e) {
        //close connection
    }
}