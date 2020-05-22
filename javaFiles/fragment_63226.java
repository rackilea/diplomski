public double getCommissionRate()
{
    if (totalSales < 500)
        return 0;
    if(totalSales < 1000)
        return .05;
    else
        return 0.1;
}