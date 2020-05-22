int nextKey = 0;
ResultSet keys = stmt.getGeneratedKeys();
if (keys.next())
{
    nextKey = keys.getInt(1);
}