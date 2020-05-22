Filter filter = new PrefixFilter(Bytes.toBytes("Mary_Ann"));
Scan scan = new Scan();
scan.setFilter(filter);
ResultScanner scanner = table.getScanner(scan);
for (Result result : scanner) {
     for (KeyValue kv : result.raw()) {
        System.out.println("KV: " + kv + ", Value: " +
        Bytes.toString(kv.getValue()));
     }
}
scanner.close();