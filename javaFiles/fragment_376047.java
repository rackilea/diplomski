private void classifier(char c)
{
    long[] s = null;

    if (c == 'L')
    {
        s = new long[] {0, dot, long_gap, long_gap, short_gap, dot, medium_gap};
    }
    vibratePattern(s);
}

private void vibratePattern(long[] s)
{
    Vibrator vibrator;
    vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    vibrator.vibrate(s, -1);
}