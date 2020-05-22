switch (AudioFileExtension.getTypeFromName(info.path ))
            {
            case AAC:
                in = new AACAudioFileReader().getAudioInputStream(file);
                decodedInput = 
                        AudioSystem.getAudioInputStream( OutputAudioFormat, in );
                break;

            case MP3:
                in = new MpegAudioFileReader().getAudioInputStream( file );
                decodedInput = 
                        AudioSystem.getAudioInputStream( OutputAudioFormat, in );
                break;