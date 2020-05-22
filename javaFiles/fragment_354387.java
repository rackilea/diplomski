if (numerator != 0) 
    {
        int common = gcd(Math.abs(numerator), denominator); // Gets a common denominator and uses abs to  make sure it is positive.
        numerator = numerator / common; // Divides top number by common #
        denominator = denominator / common; // Divides bottom number by common #
    }