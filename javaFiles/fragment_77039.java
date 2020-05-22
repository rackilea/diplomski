Configuration config = HBaseConfiguration.create();
HTable table = new HTable(config, "test");

Put p = new Put(Bytes.toBytes("yourRow"));
p.add(Bytes.toBytes("person"), Bytes.toBytes("name"),
    Bytes.toBytes("abc"));
table.put(p);