int getDayNum(int d1,int m1,int y1)    {
  if(isLeap(y1))//February leap year correction
    month[1]=29;
  else
    month[1]=28;
  int n = 0;
  for(int i = 0; i<m1; i++){
    n += month[i];
  }
  n += d1;//add days when month hasn't completed
  return n;
}