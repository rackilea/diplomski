int msTime = 60000; //1 Minute = 60000 MS
int doUntil = ms + System.currentTimeMillis(); //1 minute
while(System.currentTimeMillis() != doUntil)
{
   //Code here
   System.out.println(¨Hello World¨); //This will print Ḧello World for 60000ms

}