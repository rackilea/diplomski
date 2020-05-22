String arr[][]=new String[4][4];

//For reading name of Cold Drink
System.out.println("ENTER NAME OF COLD DRINKS");
for(int r=1;r<4;r++)
   arr[r][0]=sc.nextLine();

//For reading name of Cities
System.out.println("ENTER NAME OF CITIES");
for(int c=1;c<4;c++)
   arr[0][c]=sc.nextLine();

//For reading sales value
for(int r=1;r<4;r++)
{
 for(int c=1;c<4;c++)
  {
    System.out.println("ENTER SALES VALUE OF " + arr[r][0] + " IN CITY " + 
    arr[0][c]);
    arr[r][c]=sc.nextLine();
  }
}

//To display in format
for(int r=0;r<4;r++)
{
  for(int c=0;c<4;c++)
    System.out.print(arr[r][c]+" ");
  System.out.println();
}

//Which city consumes maximum cold drink
int maxconsumption=0;
String city=" ";
for(int c=1;c<4;c++)
{
 int temp=0;
 for(int r=1;r<4;r++)
    temp+=Integer.parseInt(arr[r][c]);
 if(temp>maxconsumption)
  {
    maxconsumption=temp;
    city=arr[0][c];
  }
 }
 System.out.println("CITY " + city +" CONSUMES MAXIMUM COLD DRINK WITH 
 VALUE = " + maxconsumption);

 //Most popular brand
 int maxsales=0;
 String brand=" ";
 for(int r=1;r<4;r++)
 {
  int temp1=0;
  for(int c=1;c<4;c++)
     temp1+=Integer.parseInt(arr[r][c]);
  if(temp1>maxsales)
  {
    maxsales=temp1;
    brand=arr[r][0];
  }
 }
 System.out.println("MOST POPULAR BRAND IS " +  brand + " WITH SALES = " + 
 maxsales);