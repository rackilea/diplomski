int tmp;
if(amount >= 100)
    {
        tmp = (int) amount/100
        print tmp + "$100 bills"
        amount = amount % 100
    }
if(amount >= 50)
    {
        tmp = (int) amount/50
        print tmp + "$50 bills"
        amount = amount % 50
    }