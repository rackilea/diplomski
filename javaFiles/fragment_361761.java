public Numbers(double A, double B, double C)
{



            if(A>=B && A>=C)
            {
                large = A;


            if(B>=C && B<=A)
            {
                medium = B;

                small = C;
            }
            else
            {
                medium = C;
                small = B;
            }

        }

    }