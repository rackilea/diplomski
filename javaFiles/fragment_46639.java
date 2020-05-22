function gcd(a, b)
    while b ≠ 0
       t := b; 
       b := a mod b; 
       a := t; 
    return a;

function gcd_r(a,b) {
    if (b = 0) {
        return a;
    }
    return gcd_r( b, a mod b );
}