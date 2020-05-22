public static String[] rowsToString(String[][] data) {
    ArrayList<String> list = new ArrayList<String>();

    for(int i = 0; i < data.length; i++) {
        String row = Arrays.toString(data[i]);
        list.add( row.substring(1, row.length()-1) );
    }

    return list.toArray(new String[0]);
}