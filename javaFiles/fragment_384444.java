public void smallestError(double[] errorCalculation, double[] mean, double[][] ratios, int length) {

double small = errorCalculation[0];
computedRatios = new double[length];
int holder = 0;
//int x = 0;
  int i =0;
  while (i<7)
    {
        if(errorCalculation[i] < small)
        {
            small = errorCalculation[i];
            holder = i;
        }
    i++;
    }


computedError = small;
computedRatios = new double[length];

int x= 0;

while (x < length){

      computedRatios[x] = ratios[holder][x];
      x++;

}
//String str1 = String.valueOf(holder);
// bigODeter = str1;
   bigODeter = holder;
}