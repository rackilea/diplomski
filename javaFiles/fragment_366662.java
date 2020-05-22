JPanel panel = new JPanel();
for (Component c : panel.getComponents()) {
    if (c instanceof DescriptionPanel)
    {
        DescriptionPanel dp = (DescriptionPanel) c;
        int hours = dp.getHours();
        // Do something with hours
    }
}