class Dog
{
    private Sound sound;

    public Sound getSound() {
        return sound;
    }
    public void setSound(Sound sound)   {
        this.sound = sound;
    }
}

class Sound
{
    private String syllable;

    Sound(String syllable)  {
        this.syllable = syllable;
    }
}