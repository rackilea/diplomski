org.nd4j.linalg.api.ndarray.INDArray arr = org.nd4j.linalg.factory.Nd4j.create(new double[][]{
                {1, 5, 0, 6, 2, 0, 9, 0, 5, 2},
                {3, 6, 1, 0, 4, 3, 1, 4, 8, 1}
        });

        org.nd4j.linalg.indexing.INDArrayIndex indices[] = {
                org.nd4j.linalg.indexing.NDArrayIndex.all(),
                new org.nd4j.linalg.indexing.SpecifiedIndex(1,5,6)
        };

        org.nd4j.linalg.api.ndarray.INDArray selected = arr.get(indices);
        System.out.println(selected);
    }