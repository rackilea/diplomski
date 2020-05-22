FFmpegMediaMetadataRetriever mmr = new FFmpegMediaMetadataRetriever();
                        mmr.setDataSource("tcp://62.109.15.84:1300");
                        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM);
                        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST);
                        Bitmap b = mmr.getFrameAtTime(2000000, FFmpegMediaMetadataRetriever.OPTION_CLOSEST); // frame at 2 seconds
                        byte [] artwork = mmr.getEmbeddedPicture();

                        mmr.release();