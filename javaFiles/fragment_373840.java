while (i <= 5)
{
  Calendar startC = Calendar.getInstance();
  Calendar endC = Calendar.getInstance();
  startC.setTimeInMillis(nu);
  endC.setTimeInMillis(nu + max);
  System.out.println("At creation time: " + startC.getTimeInMillis() 
          + " / " + endC.getTimeInMillis());
  containerList.add(new Container(startC, endC));

  nu += max;
  i++;
}