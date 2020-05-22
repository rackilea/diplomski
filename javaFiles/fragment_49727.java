byte[] normsDocLengthArrField1 = indexReader.norms("filed1");
byte[] normsDocLengthArrField2 = indexReader.norms("filed2");
byte[] normsDocLengthArrField3 = indexReader.norms("filed3");

 double sumLength = 0;
        for (int i = 0; i < normsDocLengthArrField1.length; i++) {
            double encodeLengthFOne = DefaultSimilarity.decodeNorm(normsDocLengthArrField1[i]);
            double encodeLengthFTwo = DefaultSimilarity.decodeNorm(normsDocLengthArrField2[i]);
            double encodeLengthFThree = DefaultSimilarity.decodeNorm(normsDocLengthArrField3[i]);

        //decodeNorm -Decodes a normalization factor stored in an index.
        double lengthFieldOne = 1 / (encodeLengthFOne * encodeLengthFOne);
        double lengthFieldTwo = 1 / (encodeLengthFTwo * encodeLengthFTwo);
        double lengthFieldThree = 1 / (encodeLengthFThree * encodeLengthFThree);
        sumLength += lengthFieldOne + lengthFieldTwo + lengthFieldThree;

    }
    this.avgDocLength = sumLength / (normsDocLengthArrField1.length);