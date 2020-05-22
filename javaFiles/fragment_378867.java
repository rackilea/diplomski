ArffLoader loader = new ArffLoader();
    loader.setFile(new File(""));//file is valid
    Instances structure = loader.getStructure();
    structure.setClassIndex(0);

    // train NaiveBayes
    NaiveBayesMultinomialUpdateable n = new NaiveBayesMultinomialUpdateable();
    FilteredClassifier f = new FilteredClassifier();
    StringToWordVector s = new StringToWordVector();

    f.setFilter(s);
    f.setClassifier(n);

    f.buildClassifier(structure);
    Instance current;
    while ((current = loader.getNextInstance(structure)) != null)
      n.updateClassifier(current);

    // output generated model
    System.out.println(n);