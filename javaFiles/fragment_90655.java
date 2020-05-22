splitPane.addPropertyChangeListener("dividerLocation", this);

...

public void propertyChange(PropertyChangeEvent e)
{
    //  Get the new divider location of the split pane

    int location = ((Integer)e.getNewValue()).intValue();

    if (location == 0)
        //  do something
    else if (location == splitPane.getMaximumDividerLocation())
        //  do something else
}