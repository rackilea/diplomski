public static void main(String[] args) {
        double[] Guess = { -5, -4, -3, -2, -1, -1.0 / 2, -1 / 3, -1.0 / 4.0, 0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0, 1, 2, 3, 4, 5 };
        int[] Result = {0,0,0,0};
        double e = 0.0;
        boolean first = true;
        double mu=200000, w=45,x=180,y=402,z=110;

        for(int a = 0; a<Guess.length; a++)
        {
            double W = Math.pow(w,Guess[a]);
            for(int b = 0; b<Guess.length; b++)
            {
                double X = Math.pow(x,Guess[b]);
                for(int c = 0; c<Guess.length; c++)
                {
                    double Y = Math.pow(y, Guess[c]);
                    for(int d = 0; d<Guess.length; d++)
                    {
                        double Z = Math.pow(z, Guess[d]);
                        double temp = Math.abs (W*X*Y*Z - mu);
                        if (first)
                        {
                            e = temp;
                            first = false;
                        }
                        else if (temp<e)
                        {
                            e=temp;
                            Result[0]=a;
                            Result[1]=b;
                            Result[2]=c;
                            Result[3]=d;
                        }
                    }
                }
            }
        }

        System.out.print("Error = " + e*100/mu + '\n');
        System.out.print("a=" + Guess[Result[0]] + "\nb=" + Guess[Result[1]] + "\nc=" + Guess[Result[2]] + "\nd=" + Guess[Result[3]] + '\n');
        }