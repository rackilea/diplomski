class DateDiff
  int month[] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
  int d,y,m;
  DateDiff(int d,int m,int y)    {
    this.d=d;
    this.m=m-1;
    this.y=y;
  }
  boolean isLeap(int y3)    {
    return (y3%400==0) || ((y3%100!=0)&&(y3%4==0));
  }
  int getDayNum(int d1,int m1,int y1){
    month[1] = isLeap(y1) ? 29 : 28;
    int n = 0;
    for(int i = 0; i < m1; i++){
      n += month[i];
    }
    n += d1;//add days when month hasn't completed
    return n;
  }
  int diff(int d2,int m2,int y2){
    m2--;
    int daysLeft = -getDayNum(d,m,y);
    for( int x = y; x<y2; x++ ){
      daysLeft += isLeap(x) ? 366 : 365;
    }
    daysLeft += getDayNum(d2,m2,y2);
    return daysLeft;
  }
}