// "infinite" loop as a is assigned value 10
while(a > 9)
    // when a reaches Integer.MAX_VALUE, it is still incremented by 1
    ++a;
// loop condition now false, as value for a has shifted to -2147483648
return a;