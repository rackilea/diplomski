int[] myInts = new int[5];
double[] myDoubles = new double[4];

// Initialize these arrays with "defaults" here.

// Notice how we handle the possibility of the user not entering enough values.
for (int i = 0; i < Math.min(5, args.length); i++)
    myInts[i] = Integer.parseInt(args[i]);

for (int i = 0; i < Math.min(4, args.length - 5); i++)
    myDoubles[i] = Double.parseDouble(args[i+5]);

CarPark cp = new CarPark(myInts[0], myInts[1], myInts[2], myInts[3]);