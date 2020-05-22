double min = 1.0;
double max = 10.0;
double rand = r.nextDouble();
//now we add 1 for the spread (we want the number to be from 0.5 to 10.5)
double range = max - min + 1;  
rand *=range;
//now we shift by an offset of min-0.5;
rand += (min -0.5);
//now we round the number
int intRand = Math.round(rand);