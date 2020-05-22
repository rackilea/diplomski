DataFrame df = (new CsvParser()).withUseHeader(true).csvFile(sqlContext, csvFile);

Tokenizer tokenizer = new Tokenizer();
HashingTF hashingTF = new HashingTF();
int numFeatures = 35;

tokenizer.setInputCol("Users")
        .setOutputCol("Users_words");
DataFrame df1 = tokenizer.transform(df);
hashingTF.setInputCol("Users_words")
        .setOutputCol("rawUsers").setNumFeatures(numFeatures);
DataFrame featurizedData1 = hashingTF.transform(df1);

tokenizer.setInputCol("Main_user")
        .setOutputCol("Main_user_words");
DataFrame df2 = tokenizer.transform(featurizedData1);          
hashingTF.setInputCol("Main_user_words")
        .setOutputCol("rawMain_user").setNumFeatures(numFeatures);
DataFrame featurizedData2 = hashingTF.transform(df2);             

// Now Assemble Vectors
VectorAssembler assembler = new VectorAssembler()
        .setInputCols(new String[]{"rawUsers", "rawMain_user"})
        .setOutputCol("assembeledVector");

DataFrame assembledFeatures = assembler.transform(featurizedData2);