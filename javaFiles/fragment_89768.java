public class FancyButton extends Button
{
    public FancyButton()
    {
        this.addFancyButtonListener(new SomeFancyButtonListener()
        {
            @Override
            public void fancyButtonClicked(FancyClickEvent e)
            {
                // Do something
            }
        });
    }
}