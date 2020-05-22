String mydata = "<query string>";
Pattern pattern = Pattern.compile("p0([0-9]+)=([0-9]+)&");  

Matcher matcher = pattern.matcher(mydata);
int start=0,end=0; 
if(matcher.find())
{
   start=matcher.start();
   end=matcher.end();

   System.out.println(mydata.substring(start,end-1));
}