while(playerRunning)
{
    readBuffer = getInputPCM();
    audioBytes = convertToFollowAudioFormat(readBuffer);
    sourceDataLine.write(audioBytes, 0, sdlBufferSize);
}