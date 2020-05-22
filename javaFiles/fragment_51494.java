private volatile int count;

@Override
public void run() {

.....
while (!Read.flagTerminate)
{
    synchronized(this)
    {
        if (!Read.flagTerminate)
        {
            String columnsList = getColumns(table.getColumns());
            ....
            rs = preparedStatement.executeQuery();
            ....
            if (Read.endValidRange < id && id < Read.startValidRange) 
            {
                while (rs.next()) 
                {
                    for(String column: columnsList.split(",")) 
                    {
                        System.out.println(column + ": " + rs.getString(column));
                    }
                }
            } 
            else 
            {
                while (rs.next())
                {
                    count++;
                }
            }
        }

    }
}
System.exit(0);//it implies that flag = true;

....

}

/**
 * A simple method to get the column names in the order in which it was
 * inserted
 * 
 * @param columns
 * @return
 */
private String getColumns(final List<String> columns) {
    List<String> copy = new ArrayList<String>(columns);
    Collections.shuffle(copy);

    int rNumber = random.nextInt(columns.size());

    List<String> subList = copy.subList(0, rNumber);
    Collections.sort(subList, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            return columns.indexOf(o1) < columns.indexOf(o2) ? -1 : 1;
        }
    });
    return StringUtils.join(subList, ",");
}