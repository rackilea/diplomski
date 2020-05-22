if (temp > high[day]) //assigns the current highest temperature
{                     //into the correct place in the high array
    high[day] = temp;
} else if (temp < low[day])//assigns the current lowest temperature
{                        //into the correct place in the low array
            low[day] = temp;
}