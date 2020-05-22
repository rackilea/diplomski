for(int i = 0; i < productRange.length; i++)
{   
    if(productRange[i].getProductCode().equals(productCode))
    {   
        foundProduct = productRange[i];
        break;
    }
    else
        i++;
}