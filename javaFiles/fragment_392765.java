KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke("ESCAPE");
Action escapeAction = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
        // add code to end program
    }
};

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
getRootPane().getActionMap().put("ESCAPE", escapeAction);