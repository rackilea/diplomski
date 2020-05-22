instantTooltipComponent.addMouseListener(new MouseAdapter() 
{    
    final int defaultTimeout = ToolTipManager.sharedInstance().getInitialDelay();

    @Override
    public void mouseEntered(MouseEvent e) {
        ToolTipManager.sharedInstance().setInitialDelay(0);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ToolTipManager.sharedInstance().setInitialDelay(defaultTimeout);
    }
});