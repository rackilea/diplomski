byte[] queryValue = Bytes.toBytes("x");
Scan scan = new Scan();
scan.addFamily(Bytes.toBytes("colfam1");
scan.addFamily(Bytes.toBytes("colfam2");
ResultScanner scanner = myTable.getScanner(scan);
Result res;
while((res = scanner.next()) != null) {
   NavigableMap<byte[],byte[]> colfam2 = res.getFamilyMap(Bytes.toBytes("colfam2"));
   boolean foundQueryValue = false;
   SearchForQueryValue: while(!colfam2.isEmpty()) {
       Entry<byte[], byte[]> cell = colfam2.pollFirstEntry();
       if( Bytes.equals(cell.getValue(), queryValue) ) {
           foundQueryValue = true;
           break SearchForQueryValue;
       }
   }
   if(foundQueryValue) {
       NavigableMap<byte[],byte[]> colfam1 = res.getFamilyMap(Bytes.toBytes("colfam1"));
       LinkedList<KeyValue> listKV = new LinkedList<KeyValue>();
       while(!colfam1.isEmpty()) {
           Entry<byte[], byte[]> cell = colfam1.pollFirstEntry();
           listKV.add(new KeyValue(res.getRow(), Bytes.toBytes("colfam1"), cell.getKey(), cell.getValue()); 
       }
       Result filteredResult = new Result(listKV);
   }
}