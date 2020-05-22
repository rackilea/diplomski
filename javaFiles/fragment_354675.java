public double classify(Dataset training, Dataset testing) {
        // initial the threshold and two classes
         Object[] clzz = new Object[training.classes().size()]; // <--- Init the array to the size of training
        int index = 0;
        for (Object o : training.classes()) {
            clzz[index] = o; //<-- Now everything in training has a place to be.
            index++;
        }