public void setCoefficient(int index, double value) 
{
    // you should consider adding a range check here if you want to throw
    // your own custom exception when the provided index is out of bounds
    coef[index] = value;    
}