TensorProto.Builder featuresTensorBuilder = TensorProto.newBuilder();

    for (int i = 0; i < featuresTensorData.length; ++i) {
        for (int j = 0; j < featuresTensorData[i].length; ++j) {
            for (int k = 0; k < featuresTensorData[i][j].length; ++k) {
                for (int l = 0; l < featuresTensorData[i][j][k].length; ++l) {
                    featuresTensorBuilder.addFloatVal(featuresTensorData[i][j][k][l]); //In this line
                }
            }
        }
    }