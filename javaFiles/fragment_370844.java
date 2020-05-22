JPanel panel = new JPanel()
{
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimenstion(400, 400);
    }
};

frame.add(panel, BorderLayout.CENTER);
JLabel label = new JLabel("text at the bottom of the screen");
frame.add(label, BorderLayout.PAGE_END);
frame.pack();
frame.setVisible(true);