public class FancyButton extends Button implements SomeFancyButtonListener
{
    public FancyButton()
    {
        // This line is necessary, otherwise the implemented code isn't used.
        this.addFancyButtonListener(this);
    }

    @Override
    public void fancyButtonClicked(FancyClickEvent e)
    {
        // Do something
    }
}