StringIndexer typeIndexer = new StringIndexer()
            .setInputCol("type")
            .setOutputCol("typeIndex");

    preparedData = typeIndexer.fit(preparedData).transform(preparedData);

    StringIndexer floorIndexer = new StringIndexer()
            .setInputCol("floor")
            .setOutputCol("floorIndex");

    preparedData = floorIndexer.fit(preparedData).transform(preparedData);

    StringIndexer dispositionIndexer = new StringIndexer()
            .setInputCol("disposition")
            .setOutputCol("dispositionIndex");

    preparedData = dispositionIndexer.fit(preparedData).transform(preparedData);

    String[] featureCols = new String[]{
            "squareM",
            "timeTimeToPragueCityCenter",
            "floorIndex",
            "floorIndex",
            "dispositionIndex"
    };

    VectorAssembler assembler = new VectorAssembler().setInputCols(featureCols).setOutputCol("features");

    preparedData = assembler.transform(preparedData);

 //    ... some more impelemtation details

    RandomForestRegressor rf = new RandomForestRegressor().setLabelCol("price")
            .setFeaturesCol("features");

    return rf.fit(preparedData);