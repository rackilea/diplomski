public void paint (Graphics g)
{

    g.drawImage (img, 0, 0, null);
    Dimension appletSize = this.getSize ();
    lll = getLocationOnScreen ();

    if (counter == 0) //try taking the screenshot when counter is 0
    {
        try
        {
             next2 = new Robot ().createScreenCapture (new Rectangle (lll.x, lll.y, 500, 500));
        }
        catch (java.awt.AWTException e) {}
    }
    if (next2 != null) //if you took the screenshot and saved it to next2, draw it
        g.drawImage (next2, 0, 0, null);
    System.out.println (lll);
    counter++;
}