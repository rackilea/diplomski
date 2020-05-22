public class Scenario
{
    @NotNull
    private String _id;

    private String[] _columns;

    private int _columnsSectionCount = 0;

    @XmlAttribute(name = "id")
    public String getId()
    {
        return _id;
    }

    public void setId(String id)
    {
        _id = id;
    }

    @XmlElement(name = "Column")
    @XmlElementWrapper(name = "Columns")
    public String[] getColumns()
    {
        return _columns;
    }

    public void setColumns(String[] columns)
    {
        _columns = columns;

        _columnsSectionCount++;
    }

    public int getColumnsSectionCount()
    {
        return _columnsSectionCount;
    }
}