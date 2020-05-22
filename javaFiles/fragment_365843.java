private void firstWindow()
{
    if(pFrame == null)
    {
        pFrame = new Planning();
        Dimension desktopSize = desktop.getSize();
        pFrame.setSize(desktopSize);
        desktop.add(pFrame);
        pFrame.setVisible(true);
        pFrame.moveToFront();
        try{
            pFrame.setMaximum(true);
            pFrame.setSelected(true);
        }catch(Exception e){}
    }
    else if(!pFrame.isVisible())
    {
        pFrame.setVisible(true);
        pFrame.moveToFront();
    }


    if(iFrame.isVisible())
    {
        desktop.remove(iFrame);
        iFrame = null;
    }
}

private void secondWindow()
{
    if(iFrame == null)
    {
        iFrame = new Inventory();
        Dimension desktopSize = desktop.getSize();
        iFrame.setSize(desktopSize);
        desktop.add(iFrame);
        iFrame.setVisible(true);
        iFrame.moveToFront();

        try{
            iFrame.setMaximum(true);
            iFrame.setSelected(true);
        }catch(Exception e){}
    }
    else if(!iFrame.isVisible())
    {
        iFrame.setVisible(true);
        iFrame.moveToFront();
    }

    if(pFrame.isVisible())
    {
        desktop.remove(pFrame);
        pFrame = null;
    }
}