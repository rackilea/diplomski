// Not correct Java!
string meridianNess = (hours.getValue()/12==0?"AM":"PM");
int h = hours.getValue()%12;
if (h==0) h = 12;
System.out.print(h+":"+new NumberFormat("00").format(minutes.getValue())+":"+
    new NumberFormat("00").format(seconds.getValue())+" "+meridianNess);