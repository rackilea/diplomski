int size = numAlarms; // total number of TextViews to add

TextView[] tv = new TextView[size];
TextView temp; 

for (int i = 0; i < size; i++) 
{
    temp = new TextView(this);

    temp.setText("Alarm: " + i); //arbitrary task

    // add the textview to the linearlayout
    myLinearLayout.addView(temp);

    tv[i] = temp;
}