if (Double.valueOf(YourBmi) <= 18.0)
  {
      review.setText("You are Underweight ");

  }
  else if (Double.valueOf(YourBmi) > 18.0 && Double.valueOf(YourBmi) < 25.0 )
  {
      review.setText("You are Normal (healthy weight) ");
  }
  else if(Double.valueOf(YourBmi) > 25.0)
  {
      review.setText("You are Overweight");
  }