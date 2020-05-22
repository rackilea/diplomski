public static final void setJPanelFont(JPanel aPanel, Font font)
{
    Component c = null;
    Component[] components = aPanel.getComponents();

    aPanel.setFont(font);
    if(components != null)
    {
        int numComponents = components.length;
        for(int i = 0; i < numComponents; i++)
        {
            c = components[i];
            if(c != null)
            {
                if(c instanceof JPanel)
                {
                    setJPanelFont((JPanel)c,font);
                }
                else
                {
                    c.setFont(font);
                }
            }
        }
    }
}