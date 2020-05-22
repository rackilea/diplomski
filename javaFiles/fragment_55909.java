ResultSetMetaData metaData = resultSet.getMetaData();

int count = metaData.getColumnCount();
for (int i = 1; i <= count; i++)
{
    if (metaData.getColumnName(i).equals(desiredColumnName))
    {
        // Whatever you want to do here.
    }
}