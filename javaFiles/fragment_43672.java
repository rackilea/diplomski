//global variables
float bagPrice = 1.0f, shoesPrice = 1.5f, total = 0f;

//your logic of getting values
if(beg2==true)
{
    //do what you want in textviews
    total += bagPrice;
}
else
{
    //your code
}

if (shoes1==true)
{
    //do what you want in textviews
    total += shoesPrice;
}
else
{
    //your code
}

Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show(); //show total in TextView using String.valueOf(total)