double highestprice = 0;

for (int i = 0; i < data.length; i++)
{
    if(data[i].getPrice() > highestprice)
    {
        highestprice = data[i].getPrice();
    }
}