Instances train = ...   // from somewhere
 Instances test = ...    // from somewhere
 Standardize filter = new Standardize();
 filter.setInputFormat(train);  // initializing the filter once with training set
 Instances newTrain = Filter.useFilter(train, filter);  // configures the Filter based on train instances and returns filtered instances
 Instances newTest = Filter.useFilter(test, filter);    // create new test se