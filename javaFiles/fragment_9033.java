StructType structType = new StructType();
    structType = structType.add("id1", DataTypes.LongType, false);
    structType = structType.add("id2", DataTypes.LongType, false);

    ExpressionEncoder<Row> encoder = RowEncoder.apply(structType);

    Dataset<Row> output = join.flatMap(new FlatMapFunction<Row, Row>() {
        @Override
        public Iterator<Row> call(Row row) throws Exception {
            // a static map operation to demonstrate
            List<Object> data = new ArrayList<>();
            data.add(1l);
            data.add(2l);
            ArrayList<Row> list = new ArrayList<>();
            list.add(RowFactory.create(data.toArray()));
            return list.iterator();
        }
    }, encoder);