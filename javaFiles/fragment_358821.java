public T put(int row, int column, T value) 
{
    Point p = new Point();
    p.x = column;
    p.y = row;
    this.matrixMap.put(p, value);
    return value;
}