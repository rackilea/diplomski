int[] counts = new int[6];
for (int i=0; i<die.length; i++)
    //increase the relevant counter
    counts[die[i]-1]++;
//now check we've got a 2 and a 3
boolean check2 = false;
boolean check3 = false;
for (int i: counts) {
    check2 |= (i==2); //found 2 of some number
    check3 |= (i==3); //found 3 of some number
    if (i==5) return true; //found a Yahtzee so stop and return true
}
return (check2 && check3);