public static void play(File[] files)
{
                // local vars
                byte[]          b;              // array for the actual audio Data during the playback
                AudioTrack      track;          // track we are playing atm
                AudioFormat     af;             // the track's format
                SourceDataLine  line;           // the line we'll use the get our audio to the speaker's
                Decoder         dec;            // decoder to get the audio bytes
                Frame           frame;          //
                SampleBuffer    buf;            //
                int             currentTrack;   // index of current track from playlist
                MP4Container    cont;           // container to open the current track with
                Movie           movie;          // and get the content from the container

                try
                {
                    // for-next loop to play each titel from the playlist once
                    for (currentTrack = 0; currentTrack < files.length; currentTrack++)
                    {
                        cont    = new MP4Container(new RandomAccessFile(files[currentTrack], "r")); // open titel with random access
                        movie   = cont.getMovie();                          // get content from container,
                        List<Track> content = movie.getTracks();
                        if (content.isEmpty())                              // check if container HAS content
                            throw new Exception ("insert error message here");  // if so,
                        track   = (AudioTrack) movie.getTracks().get(0);    // grab first track and set the audioformat
                        af      = new AudioFormat(track.getSampleRate(), track.getSampleSize(), track.getChannelCount(), true, true);
                        line    = AudioSystem.getSourceDataLine(af);        // get a DataLine from the AudioSystem
                        line.open();                                        // open and
                        line.start();                                       // start it

                        dec     = new Decoder(track.getDecoderSpecificInfo());

                        buf = new SampleBuffer();
                        while(track.hasMoreFrames())                // while we have frames left
                        {
                            frame = track.readNextFrame();          // read next frame,
                            dec.decodeFrame(frame.getData(), buf);  // decode it and put into the buffer
                            b = buf.getData();                      // write the frame data from the buffer to our byte-array
                            line.write(b, 0, b.length);             // and from there write the byte array into our open AudioSystem DataLine

                            while (paused)                  // check if we should pause
                            {
                                Thread.sleep(500);          // if yes, stay half a second

                                if (Thread.interrupted())   // check if we should stop possibly
                                {
                                    line.close();           // if yes, close line and
                                    return;                 // exit thread
                                }
                            }

                            if (Thread.interrupted())       // if not in pause, still check on each frame if we should
                            {                               // stop. If so
                                line.close();               // close line and
                                return;                     // exit thread
                            }
                        }

                        line.close();           // after titel is over, close line

                        if (loop)               // if we should loop current titel, set currentTrack -1,
                            currentTrack--;     // as on bottom of for-next it get's +1 and so the same titel get's played again
                        else if (repeat && (currentTrack == files.length -1)) // else check if we are at the end of the playlist
                            currentTrack = -1;  // and should repeat the whole list. If so, set currentTrack -1, so it get's 0 on for-next bottom
                    }
                }
                catch (LineUnavailableException | IOException | InterruptedException e)
                {
                    e.printStackTrace();
                }
}