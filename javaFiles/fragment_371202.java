List<Object[]> rowList = new ArrayList<Object[]>();

rowList.add(new Object[] { 'a', 5, 6 });
rowList.add(new Object[] { 'b', 5, 6 });
rowList.add(new Object[] { 7, 8 });

for (Object[] row : rowList) 
{
    System.out.println("Row = " + Arrays.toString(row));
}