FileInputStream fin = null;
    BufferedInputStream bin = null;
    try
    {
        fin = new FileInputStream("res/FancyPants.wav");
        bin = new BufferedInputStream(fin);
    }
    catch(FileNotFoundException e)
    {
        e.printStackTrace();
    }
    WaveData waveFile = WaveData.create(bin);
    AL10.alBufferData(buffer.get(0), waveFile.format, waveFile.data, waveFile.samplerate);

    waveFile.dispose();