public double valueOne(double alfa, double beta)
{
    // At least one of the values is invalid.
    if (Double.isNaN((alfa) || Double.isNaN((beta))
    {
        return Double.NaN;
    }

    // Check the alpha or otherwise a div/0 exception may be thrown.
    if (alfa == 0.0)
    {
        return Double.NaN;
    }

    double divResult = (-beta)/alfa;

    // Check the div result because Math.sqrt accepts only positive values:
    // If the argument is NaN or less than zero, the result is NaN. 
    if (divResult < 0.0)
    {
        return Double.NaN;
    }

    return (-(Math.sqrt(divResult)))+alfa;
}

double resultValueOne = valueOne(alfa, beta);  
if(Double.isNaN((resultOne))
{
    System.out.println("No resultValueOne");
}