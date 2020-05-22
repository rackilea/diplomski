OLSMultipleLinearRegression regr = new OLSMultipleLinearRegression();
regr.newSampleData(y, x);
double SSR1 = regr.calculateResidualSumOfSquares();
double df1 = y.length - (x[0].length + 1); 
    //df = n - number of coefficients, including intercept

regr.newSampleData(y, xb);
double SSR2 = regr.calculateResidualSumOfSquares();
double df2 = y.length - (xb[0].length + 1);

double MSE = SSR2/df2; // EDIT: You need the biggest model here!
double MSEdiff = Math.abs ((SSR2 - SSR1) / (df2 - df1));
double dfdiff = Math.abs(df2 - df1);

double Fval = MSEdiff / MSE;

FDistribution Fdist = new FDistribution(dfdiff, df2);
double pval = 1 - Fdist.cumulativeProbability(Fval);