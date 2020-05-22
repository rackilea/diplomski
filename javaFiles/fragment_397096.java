@Override
public int compareTo(AudioEvent other)
{
    if (frame < other.getFrame()) return -1;
    // correct
    if (frame > other.getFrame()) return 1;
    // following is the compare error that WAS here
    // if (frame >= other.getFrame()) return 1;

    return 0;
}