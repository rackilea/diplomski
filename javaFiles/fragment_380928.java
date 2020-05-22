static MyInfoBubble lastBubble;


public static void main(String[] args)
{
    JFrame frame = new JFrame();
    frame.setSize(new Dimension(500, 500));

    JPanel glassPane = new JPanel();
    glassPane.setOpaque(false);
    glassPane.setLayout(null);

    frame.setGlassPane(glassPane);
    frame.getGlassPane().setVisible(true);

    JPanel labelRowPanel = new JPanel();
    for (int ctr = 0; ctr < 7; ctr++) {
        labelRowPanel.add(makeButton(frame, "Button " + ctr));
    }

    frame.getContentPane().add(labelRowPanel);
    frame.setVisible(true);
}



private static JButton makeButton(final JFrame frame, final String label) {
    final JButton button = new JButton(label);

    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent arg0)
        {
            if (lastBubble != null)
            {
                lastBubble.setVisible(false);
                ((JPanel)frame.getGlassPane()).remove(lastBubble);
                lastBubble = null;
            }

            Point loc = button.getLocation();
            MyInfoBubble mib = new MyInfoBubble();
            mib.setBounds(loc.x+10, loc.y+30, 100, 50);
            ((JPanel)frame.getGlassPane()).add(mib);
            lastBubble = mib;

            ((JPanel)frame.getGlassPane()).validate();
            ((JPanel)frame.getGlassPane()).repaint();
        }

    });

    return button;
}


static class MyInfoBubble extends JPanel
{
    public MyInfoBubble()
    {
        setVisible(true);
    }


    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLUE);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
    }

}