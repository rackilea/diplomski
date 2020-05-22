public void genTone(){
    try
        {
        System.out.println("test");
        dF.calculateFreq();
        tone = audio.getSineWave(noteDuration, 10000, 200);
        audio.writeSound(tone);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}