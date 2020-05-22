StructType schema = new StructType(new StructField[]{
            new StructField("customer_id", DataTypes.StringType, false, Metadata.empty()),  
            new StructField("product", DataTypes.StringType, false, Metadata.empty()),          
            new StructField("price", DataTypes.IntegerType, false, Metadata.empty()),               
            new StructField("bought_date", DataTypes.StringType, false, Metadata.empty()),
        });

ArrayType arrSchema = new ArrayType(schema, false);