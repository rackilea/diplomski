public static boolean isPrime(int x)
{
    if(x<2)
    return false; 
    if(x==2)
    return true;
    // boolean prime = true; you dont need the variavle
    if (x % 2 == 0)
        return false;
// using return is faster as you dont need to do more conditions
// also, you dont need the if. You could use else, if you dont want to return
// immediately   
        for (int i = 3; i*i <= x; i+=2)
        {
            if (x % i == 0)
                return false;
        }

    return true;
}