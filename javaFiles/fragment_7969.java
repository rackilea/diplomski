public static void wrapTextToPolygon(Graphics2D g, String text, Font font, Color color, java.awt.Shape shape, int x, int y, int border)
{
    FontMetrics m = g.getFontMetrics(font);
    java.awt.Shape poly = shape;
    int num = 0;
    String[] words = new String[1];
    if(text.contains(" "))
    {
        words = text.split(" ");
    }
    else words[0] = text;
    int yi = m.getHeight() + border;
    num = 0;
    while(num != words.length)
    {
        String word = words[num];
        Rectangle rect = new Rectangle((poly.getBounds().width / 2) - (m.stringWidth(word) / 2) + x - border - 1, y + yi, m.stringWidth(word) + (border * 2) + 2, m.getHeight());
        while(!poly.contains(rect))
        {
            yi += m.getHeight();
            rect.y = y + yi;
            if(yi >= poly.getBounds().height) break;
        }
        int i = 1;
        while(true)
        {
            if(words.length < num + i + 1)
            {
                num += i - 1;
                break;
            }
            rect.width += m.stringWidth(words[num + i]) + (border * 2);
            rect.x -= m.stringWidth(words[num + i]) / 2 - border;
            if(poly.contains(rect))
            {
                word += " " + words[num + i];
            }
            else
            {
                num += i - 1;
                break;
            }
            i = i + 1;
        }
        if(yi < poly.getBounds().height)
        {
            g.drawString(word, (poly.getBounds().width / 2) - (m.stringWidth(word) / 2) + x, y + yi);
        }
        else
        {
            break;
        }
        yi += m.getHeight();
        num += 1;
    }
}