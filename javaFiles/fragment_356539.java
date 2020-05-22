onUpdate(float val)
{
    if (val == 0)
    {
        bar.getStyle().knob = invisTextureBar;
    } 
    else 
    {
        bar.getStyle().knob = textureBar;
    }

    bar.getStyle().knobBefore = bar.getStyle().knob;

    bar.setValue(val);
}