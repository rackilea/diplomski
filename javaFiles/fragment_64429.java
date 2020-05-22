double d = 0.0;
double exp =1.0;
for (int i=1;i<=53;i++) {
  exp=exp*2.0;
  d+=1.0/exp;
}
System.out.println (d);
System.out.println ("d==1.0? " + (d==1.0));