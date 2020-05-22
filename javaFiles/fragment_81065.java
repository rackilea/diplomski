// generic declaration after public, before void
public <T extends Number> void addPlot(String plotName, int minX, int maxX,
        int minY, int maxY, PlotStyle plotStyle, Class<T> type)
{
    Vector<T> dataset = new Vector<T>();
}