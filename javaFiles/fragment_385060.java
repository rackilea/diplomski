try(SourceDataLine sdl = AudioSystem.getSourceDataLine(audioFormat)) {
    sdl.open(audioFormat, bufferSize);
    // work with sdl
}
catch(LineUnavailableException ex) {
    throw new RuntimeException(ex);
}