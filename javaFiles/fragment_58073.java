public final void cook()
{
    cookImpl();
    finalMandatoryTouch();
}

protected abstract void cookImpl();