public void paintComponent (Graphics page)
{
    super.paintComponent (page);
    int x = 0, y = 0, diameter = MAX_WIDTH;

    Color myColors[] = { Color.red, Color.yellow, Color.pink, Color.green, Color.purple, Color.orange, Color.blue };

    for (int count = 0; count < NUM_RINGS; count++)
    {
        page.setColor (myColors[count%NUM_RINGS]);
        page.fillArc (x, y, diameter, diameter, 0, 180);

        diameter -= (2 * RING_WIDTH);
        x += RING_WIDTH;
        y += RING_WIDTH;
    }
}