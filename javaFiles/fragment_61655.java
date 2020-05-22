public class DataSet {

    @XmlPath("node[@name='columns']")
    @XmlJavaTypeAdapter(DataSetListPropertyAdapter.class)
    private Columns columns;

    @XmlPath("node[@name='resultSet']")
    @XmlJavaTypeAdapter(DataSetListPropertyAdapter.class)
    private ResultSet resultSet;

    ...
}