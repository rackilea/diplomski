//first convert the columns Size and Records to a List<Double>
List<Double> sizeList = dataFrame.select("Size").javaRDD().map(f -> f.getDouble(0)).collect();
List<Double> recordsList = dataFrame.select("Records").javaRDD().map(f -> f.getDouble(0)).collect();

//then convert the lists into JavaDoubleRDD
JavaDoubleRDD size = sparkContext.parallelizeDoubles(sizeList);
JavaDoubleRDD records = sparkContext.parallelizeDoubles(recordsList);

//calculate the mean and stddev using the built in functions:
double sizeMean = size.mean();
double sizeStdev = size.stdev();
double recordsMean = records.mean();
double recordsStdev = records.stdev();