public static long indivisbleBy_2or3or5(long t) {
    long x, y, z;

    //amount of numbers divisible by 2, and several for 3 and 5. 
    x = t / 2;

    //amount of numbers divisible by 3 - numbers divisible by 3 and 2 = amount of numbers divisible by 3, and several for 5.
    y = t / 3;
    y = y - y / 2;

    //amount of numbers divisible by 5 - numbers divisible by 5 and 2 - (numbers divisible by 5 and 3 - numbers divisible by 5 and 3 and 2)  = number only divisible by 5  
    z = t / 5;
    z = z - z / 2 - (z / 3 - z / (2 * 3) );

    //All numbers - (The amount of numbers divisible by 2, and several for 3 and 5 
    //+ The amount of numbers divisible by 3 and several for 5 + number only divisible by 5)
    //= indivisible by 2 or 3 or 5
    return t - (x + y + z);
}