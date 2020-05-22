for(int i = 0; i < lines.size(); i += 4)
{
    if((i+3) < lines.size())
    {
        g.drawLine(lines.get(i), lines.get(i + 1), lines.get(i + 2), lines.get(i + 3));
    }
}