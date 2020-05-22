for (int i = 0; i < labeled.size(); i++)      
{
// Discreet prediction

double predictionIndex = 
    clf.classifyInstance(newTest.instance(i)); 

// Get the predicted class label from the predictionIndex.
String predictedClassLabel =
    newTest.classAttribute().value((int) predictionIndex);

// Get the prediction probability distribution.
double[] predictionDistribution = 
    clf.distributionForInstance(newTest.instance(i)); 

// Print out the true predicted label, and the distribution
System.out.printf("%5d: predicted=%-10s, distribution=", 
                  i, predictedClassLabel); 

// Loop over all the prediction labels in the distribution.
for (int predictionDistributionIndex = 0; 
     predictionDistributionIndex < predictionDistribution.length; 
     predictionDistributionIndex++)
{
    // Get this distribution index's class label.
    String predictionDistributionIndexAsClassLabel = 
        newTest.classAttribute().value(
            predictionDistributionIndex);

    // Get the probability.
    double predictionProbability = 
        predictionDistribution[predictionDistributionIndex];

    System.out.printf("[%10s : %6.3f]", 
                      predictionDistributionIndexAsClassLabel, 
                      predictionProbability );

    // Write to CSV
    builder.append(i+","+
            predictionDistributionIndexAsClassLabel+","+predictionProbability);


}

System.out.printf("\n");
builder.append("\n");

}


// Save results in .csv file
outFile.write(builder.toString());//save the string representation