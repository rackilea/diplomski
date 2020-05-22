if(nowHour>=0 &&<nowHour<=6)
{
  textView.setText("late night");
}
else if(nowHour>=7 &&<nowHour<=11)
{
   textView.setText("morning");
}
else if(nowHour>=12 &&<nowHour<=15)
{
   textView.setText("noon");
}
else if(nowHour>=16 &&<nowHour<=18)
{
   textView.setText("afternoon");
} //and so on