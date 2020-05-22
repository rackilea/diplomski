private void play() {
    try {
        this.source = openAL.createSource();
        this.outputWriter = new OutputWriter(this.socket.getInputStream(), this.source, this.soundObject.getAudioFormat());
        this.source.setGain(1f);
        this.outputWriter.start();
    } catch (Exception ex) {
        Log.severe(ex.toString());
    }
}