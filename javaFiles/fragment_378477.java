Point point = new Point(event.x, event.y);
int column = 0;
for (int i = 0; i < table.getColumnCount(); i++)
{
    if (item.getBounds(i).contains(point))
    {
        column = i;
        break;
    }
}

Rectangle rect = item.getBounds(column);