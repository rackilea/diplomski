// outer for loop
   int colorIndex = 0;

   for (int i = 0; i < rows; i++) {

        if (index == 0)
        {
            //set background
            row.setBackgroundColor(getResources().getColor(R.color.some_color));
            index++;
        }

        else if (index == 1)
        {
            //set background
            row.setBackgroundColor(getResources().getColor(R.color.some_other_color));
            index++;
        }
        if (index == 2)
        {
            //set background
            row.setBackgroundColor(getResources().getColor(R.color.yet_another_color));
            index = 0;
        }
}