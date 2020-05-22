String[] options = {
                            ":sharpen-sigma=2.0", 
                            ":blur-factor=127", 
                            ":ipv4-timeout=3000", 
                            ":no-video-title-show", 
                            ":loop", 
                            ":file-caching="+getFileCaching(),
                            ":sout-all",
                            ":sout-keep"
                    };

                    gc.getMediaPlayer().setRepeat(true);
                    gc.getMediaPlayer().setPlaySubItems(true);
                    gc.getMediaPlayer().playMedia(media, options);