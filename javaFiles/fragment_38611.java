AudioFormat format = audioInputStream.getFormat();
newFormat=new AudioFormat(
          AudioFormat.Encoding.PCM_SIGNED,
          format.getSampleRate(),
          16,
          format.getChannels(),
          format.getChannels() * 2,
          format.getSampleRate(),
          false);