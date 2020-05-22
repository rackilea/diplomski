if ((day>=1 && month>=4) && (day<=30 && month<=9))
{
    if((hour<=16 && min<30)||(hour>=23 && min>0))
    {
    message="something";
    }//if#2
    else
    {
     Log.d("baja", "before if#3 ");
    }//else
}//if#1
else if((hour<=16 && min<30)||(hour>=21 && min>0))
{
    Log.d("baja", "if#3");
    message="something2";
}//if#3