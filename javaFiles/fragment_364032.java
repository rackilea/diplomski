public int powerN(int base, int exponent)  {
    if the exponent is 0
        then return 1
    otherwise, if the exponent is even
        then return base * base
    otherwise
        base * powerN(base, exponent - 1)
}