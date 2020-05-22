StructType customStructType = new StructType();
        customStructType = customStructType.add("obj1", DataTypes.< type>, false);
        customStructType = customStructType.add("obj2", DataTypes.< type >, false);
        ExpressionEncoder<Row> customTypeEncoder = null;

        Dataset<Row> changed_data = original_data.map(row->{
            return RowFactory.create(obj1,obj2);;
    }, RowEncoder.apply(customStructType));