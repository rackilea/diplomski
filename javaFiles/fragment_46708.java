private Decoder decoder;
private float totalMs;
private Bitstream bitstream;
private InputStream inputStream;

//call this once, when it is time to start a new song:
private void startNewSong(String path) throws IOException
{
    decoder = new Decoder();
    totalMs = 0;
    File file = new File(path);
    inputStream = new BufferedInputStream(new FileInputStream(file), 8 * 1024);
    bitstream = new Bitstream(inputStream);
}

private byte[] decode(String path, int startMs, int maxMs)
        throws IOException {
    ByteArrayOutputStream outStream = new ByteArrayOutputStream(1024);


    try {
        boolean done = false;
        while (! done) {
            Header frameHeader = bitstream.readFrame();
            if (frameHeader == null) {
                done = true;
                inputStream.close();   //Note this change. Now, the song is done. You can also clean up the decoder here.
            } else {
                totalMs += frameHeader.ms_per_frame();

                SampleBuffer output = (SampleBuffer) decoder.decodeFrame(frameHeader, bitstream);

                if (output.getSampleFrequency() != 44100
                        || output.getChannelCount() != 2) {
                    Log.w("ERROR", "mono or non-44100 MP3 not supported");
                }

                short[] pcm = output.getBuffer();
                for (short s : pcm) {
                    outStream.write(s & 0xff);
                    outStream.write((s >> 8) & 0xff);
                }

                if (totalMs >= (startMs + maxMs)) {
                    done = true;
                }
            }
            bitstream.closeFrame();
        }
    } catch (BitstreamException e) {
        throw new IOException("Bitstream error: " + e);
    } catch (DecoderException e) {
        Log.w("ERROR", "Decoder error", e);
    }
    return outStream.toByteArray();
}