StringToWordVector  strWVector = new StringToWordVector();   
    filteredClassifier fcls = new FilteredClassifier();
    fcls.setFilter(strWVector);
    fcls.setClassifier(new SMO());
    fcls.buildClassifier(yourdata)
     //rest of your code