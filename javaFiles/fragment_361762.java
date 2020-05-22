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

  } else if if(B>=A && B>=C)
  {
    //B is the largest, add code to determine medium and small as you did before
  } else {
    //C is the largest, add code to determine medium and small as you did before
  }

}