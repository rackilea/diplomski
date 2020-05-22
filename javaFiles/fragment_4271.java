public class CachedSoundClipTest
{
    static ArrayList<AudioInputStream> cachedSounds = 
        new ArrayList<AudioInputStream>();

    public static void main(String[] args) throws Exception
    {
        File[] audioFiles = new File("/audio_storage_directory").listFiles();
        for (File file : audioFiles)
        {
            AudioInputStream reusableAudioInputStream = 
                createReusableAudioInputStream(file);
            cachedSounds.add(reusableAudioInputStream);
        }

        while(true)
        {
            System.out.println("Press enter to play next clip");
            BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
            playCachedSound(0);
        }
    }

    private static void playCachedSound(int i) 
        throws IOException, LineUnavailableException
    {
        AudioInputStream stream = cachedSounds.get(i);
        stream.reset();
        Clip clip = AudioSystem.getClip();
        clip.open(stream);
        clip.start();
    }

    private static AudioInputStream createReusableAudioInputStream(File file) 
        throws IOException, UnsupportedAudioFileException
    {
        AudioInputStream ais = null;
        try
        {
            ais = AudioSystem.getAudioInputStream(file);
            byte[] buffer = new byte[1024 * 32];
            int read = 0;
            ByteArrayOutputStream baos = 
                new ByteArrayOutputStream(buffer.length);
            while ((read = ais.read(buffer, 0, buffer.length)) != -1)
            {
                baos.write(buffer, 0, read);
            }
            AudioInputStream reusableAis = 
                new AudioInputStream(
                        new ByteArrayInputStream(baos.toByteArray()),
                        ais.getFormat(),
                        AudioSystem.NOT_SPECIFIED);
            return reusableAis;
        }
        finally
        {
            if (ais != null)
            {
                ais.close();
            }
        }
    }
}