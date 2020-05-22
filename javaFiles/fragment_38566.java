@Override
public JToolTip createToolTip() 
{
    JToolTip tooltip = super.createToolTip();
    tooltip.setBorder(BorderFactory.createLineBorder(new Color(76,79,83)));
    tooltip.setBackground(new Color(255, 247, 200));  
    return tooltip;
}