FocusListener fl = new FocusAdapter()
{
    public void focusGained(FocusEvent e)
    {
        String eventText = e.toString();

        if (eventText.contains("TRAVERSAL_FORWARD"))
            System.out.println("forward");
        else if (eventText.contains("TRAVERSAL_BACKWARD"))
            System.out.println("backward");
    }
};