for( Map<String, Object> row : result ) {
for ( Entry<String, Object> column : row.entrySet() ){

String key = column.getKey();

Object value = column.getValue();
if(key.equals("nc1")){
     System.out.println(value);

  int[] array=new int[(int) value];
     System.out.println(array[0]);
     System.out.println(array[1]);
     System.out.println(array[2]);//Upto the no. of value of nc1
}
}