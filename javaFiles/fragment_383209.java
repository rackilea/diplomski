class Triangle
{
private double bigside;
private double leg;
private double arm;

public Triangle(double sideA, double sideB, double sideC)
{

    if(sideA>sideB)
    {
        if(sideA > sideC)
        {
            bigside = sideA;
            leg = sideB;
            arm = sideC;
        }
        else
        {
            bigside = sideC;
            leg = sideB;
            arm = sideA;
        }
    }
    if (sideB > sideC)
    {
        bigside =sideB;
        leg = sideA;
        arm = sideC;
    }
    if(sideC > sideA)
    {
        bigside = sideC;
        leg = sideB;
        arm = sideA;
    }
}

public String typeOfTriangle() {
     if (isTriangle(arm, leg, bigside )== true)
    {
        if (isRight(arm, leg, bigside )== true)
        {
            return "is Right";
        }
        else    {
            return "A triangle";
            }
    }
    else    {
        arm = 1.0;
        leg = 1.0;
        bigside = 1.0;
        return "Not a triangle";
    }
     return "is Equilateral";
}


public static boolean isTriangle(double arm, double leg, double bigside)
{
    if (arm + leg > bigside)
    {
        return true;
    }
    {
        return false;
    }
}
public static boolean isRight(double leg, double arm, double bigside)
{
    if (leg*leg + arm*arm == bigside*bigside)
    {
        return true;
    }
    {
        return false;
    }
   }
}