for (Enemy en : enemies)
{
    if (en.isDead() == true)
    {
        en.startFadeOut();
    }
    else if (en.isFadeFinished())
    {
        // guessing some alpha channel property.
        en.setAlpha(en.getAlpha() - 0.1 * ticks);
        if (en.getAlpha() <= 0)
        {
            en.setFadeFinished(true);
        }
    }
    en.update();
}