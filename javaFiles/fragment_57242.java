//Make a layout programmatically
LinearLayout lnLayout = new LinearLayout(this);
lnLayout.setLayoutParams(new ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.WRAP_CONTENT));
lnLayout.setOrientation(LinearLayout.Horizontal);

//Your code was a bit unclear so I assume these
int[] missingNumber = new int[/*the ammount of missing numbers*/];
for (int iii < 0; iii < missingNumber.length; iii++)
    missingNumber[iii] = /* Here you should use something to get missing numbers one by one, a method like "GetNumber(iii)" or whatever suits your need :) */

//For each missing number create one text view (inside an array is better)
TextView[] text = new TextView[missingNumber.length];
for (int iii = 0; iii < missingNumber.length; iii++)
{
    text[iii] = new TextView(this);
    text[iii].setLayoutParams(new ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT));
    text[iii].setText( String.valueOf( missingNum(iii) ) );
    lnLayout.addView(text[iii]);
}

setContentView(lnLayout);