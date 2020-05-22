ArrayList<String[]> rowAr = new ArrayList<String[]>();
HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
int index = 0;
for (String rowStr: rows) {
    String[] row = rowStr.split(";");
    rowAr.add(row);
    String companyCode = row[0];
    //please keep in mind that for simplicity of the example I avoided
    //creation of new array if it does not exist in HashMap
    ((ArrayList<Integer>)map.get(companyCode)).add(index);
    index++;
}