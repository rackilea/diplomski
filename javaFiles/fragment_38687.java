public static double sumGeom(double term, double ratio, int n)
{
    if (n<=1)
    {

        System.out.println("term : "+ term + " ");

        System.out.println("ratio : "+ ratio + " ");

        System.out.println("n : " + n);

        return term;
    }
    else
    {

        System.out.println("term : "+ term + " ");

        System.out.println("ratio : "+ ratio + " ");

        System.out.println("n : " + n);

        term = term + sumGeom(term * ratio, ratio, n-1);

        System.out.println("term : "+ term + " ");

        System.out.println("ratio : "+ ratio + " ");

        System.out.println("n : " + n);

        return term;
    }
}

//Result will be this
term : 2.0 
ratio : 2.0 
n : 5
term : 4.0 
ratio : 2.0 
n : 4
term : 8.0 
ratio : 2.0 
n : 3
term : 16.0 
ratio : 2.0 
n : 2
term : 32.0 
ratio : 2.0 
n : 1
term : 48.0 
ratio : 2.0 
n : 2
term : 56.0 
ratio : 2.0 
n : 3
term : 60.0 
ratio : 2.0 
n : 4
term : 62.0 
ratio : 2.0 
n : 5
result : 62.00000