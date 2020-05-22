while((newSum != sum) || (newSum != 7))
{                   
    reroll1 = rng.nextInt(6) + 1;
    reroll2 = rng.nextInt(6) + 1;
    newSum = reroll1 + reroll2;
}