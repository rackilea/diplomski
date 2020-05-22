public void setColour(Color c)
{
    if (!getBackground().equals(c))
    {
       setBackground(c);
       notify(new ColorChangedEvent(this, c));
    }
}