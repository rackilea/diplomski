PlayingSound() {
            Thread playingSound = new Thread(() -> {

                //REMOVED THE DO WHILE LOOP HERE
                try {
                    AudioInputStream in;
                    in = getAudioInputStream(new File(fileName));
                    final AudioFormat outFormat = getOutFormat(in.getFormat());
                    final Info info = new Info(SourceDataLine.class, outFormat);
                    try(final SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info)) {
                        if(line != null) {
                            line.open(outFormat);
                            line.start();
                            AudioInputStream inputMystream = AudioSystem.getAudioInputStream(outFormat, in);
                            stream(outFormat, inputMystream, line);
                            line.drain();
                            line.stop();
                        }
                    }
                }
                catch(UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                    throw new IllegalStateException(e);
                }
                finally {
                    removeInternalSound(this);
                }
            });
            playingSound.start();
        }

        /**
         * Streams the audio to the mixer
         *
         * @param in   Input stream to audio file
         * @param line Where the audio data can be written to
         * @throws IOException Thrown if given file has any problems
         */
        private void stream(AudioFormat outFormat, AudioInputStream in, SourceDataLine line) throws IOException {
            byte[] buffer = new byte[32];
            do {
                for(int n = 0; n != -1 && !stop; n = in.read(buffer, 0, buffer.length)) {
                    byte[] bufferTemp = new byte[buffer.length];
                    for(int i = 0; i < bufferTemp.length; i += 2) {
                        short audioSample = (short) ((short) ((buffer[i + 1] & 0xff) << 8) | (buffer[i] & 0xff));
                        bufferTemp[i] = (byte) audioSample;
                        bufferTemp[i + 1] = (byte) (audioSample >> 8);
                    }
                    buffer = bufferTemp;
                    line.write(buffer, 0, n);
                }
                in = getAudioInputStream(new File(fileName));
                in = AudioSystem.getAudioInputStream(outFormat, in);
            } while(loopable && !stop);
        }