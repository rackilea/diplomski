private int calculate(double numberToCalculate) {
    double gap;

    if(numberToCalculate < 1000)
    {
        gap = 10;       
    }
    else if(numberToCalculate < 5000)
    {
        gap = 50;
    }
    else //5000+
    {
        gap = 1000;
    }

    int my_result = Math.ceil((numberToCalculate / gap)) * gap;
    return my_result;