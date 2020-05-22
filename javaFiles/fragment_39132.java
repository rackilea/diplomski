import java.util.*;
import java.text.*;

public class Proj3 {
public static void main(String[] args) {
Scanner s= new Scanner(System.in);
String input;

double xOne = 0;
double yOne = 0;
double xTwo = 0;
double yTwo = 0;
double slope;
DecimalFormat df = new DecimalFormat("#0.00");

do
{
do
{
    xOne=0;
System.out.print("Enter x1: ");
input = s.nextLine();
xOne=Double.parseDouble(input);

if(xOne<0||xOne>9)
    {
    System.out.println("Point entered is not between 0 and 9, enter again");
    }
}while(xOne<0||xOne>9);

do
{
    yOne=0;
System.out.print("Enter y1: ");
input = s.nextLine();
yOne=Double.parseDouble(input);

if(yOne<0||yOne>9)
    {
    System.out.println("Point entered is not between 0 and 9, enter again");
    }
}while(yOne<0||yOne>9);

do
{
    xTwo=0;
System.out.print("Enter x2: ");
input = s.nextLine();
xTwo=Double.parseDouble(input);

if(xTwo<0||xTwo>9)
    {
    System.out.println("Point entered is not between 0 and 9, enter again");
    }
}while(xTwo<0||xTwo>9);

do
{
    yTwo=0;
System.out.print("Enter y2: ");
input = s.nextLine();
yTwo=Double.parseDouble(input);

if(yTwo<0||yTwo>9)
    {
    System.out.println("Point entered is not between 0 and 9, enter again");
    }
}while(yTwo<0||yTwo>9);

slope=((yTwo-yOne)/(xTwo-xOne));

if((xOne==xTwo)&&(yOne==yTwo))
{
    System.out.println("Same point entered twice, enter again");
}

else if(xOne==xTwo)
{
    System.out.println("Slope is undefined, enter again");
}

}while((xOne==xTwo)||((xOne==xTwo)&&(yOne==yTwo)));

System.out.println("y = " + (df.format(slope)) + "x + " + (df.format(yOne-slope*xOne)));


for(int i=9; i>=0;i--){

if(xOne==0||xTwo==0)
{
    if((i==9)&&(((xOne==0&&yOne==9)||(xTwo==0&&yTwo==9))))
        System.out.println(i + " *");
    else if((i==8)&&(((xOne==0&&yOne==8)||(xTwo==0&&yTwo==8))))
        System.out.println(i + " *");
    else if((i==7)&&(((xOne==0&&yOne==7)||(xTwo==0&&yTwo==7))))
        System.out.println(i + " *");
    else if((i==6)&&(((xOne==0&&yOne==6)||(xTwo==0&&yTwo==6))))
        System.out.println(i + " *");
    else if((i==5)&&(((xOne==0&&yOne==5)||(xTwo==0&&yTwo==5))))
        System.out.println(i + " *");
    else if((i==4)&&(((xOne==0&&yOne==4)||(xTwo==0&&yTwo==4))))
        System.out.println(i + " *");
    else if((i==3)&&(((xOne==0&&yOne==3)||(xTwo==0&&yTwo==3))))
        System.out.println(i + " *");
    else if((i==2)&&(((xOne==0&&yOne==2)||(xTwo==0&&yTwo==2))))
        System.out.println(i + " *");
    else if((i==1)&&(((xOne==0&&yOne==1)||(xTwo==0&&yTwo==1))))
        System.out.println(i + " *");
    else if((i==0)&&(((xOne==0&&yOne==0)||(xTwo==0&&yTwo==0))))
        System.out.println(i + " * — — — — — — — — — — — — — — — — — — —");
}

if(xOne==1||xTwo==1)    
{
    if((i==9)&&(((xOne==1&&yOne==9)||(xTwo==1&&yTwo==9))))
        System.out.println(i + " |   *");
    else if((i==8)&&(((xOne==1&&yOne==8)||(xTwo==1&&yTwo==8))))
        System.out.println(i + " |   *");
    else if((i==7)&&(((xOne==1&&yOne==7)||(xTwo==1&&yTwo==7))))
        System.out.println(i + " |   *");
    else if((i==6)&&(((xOne==1&&yOne==6)||(xTwo==1&&yTwo==6))))
        System.out.println(i + " |   *");
    else if((i==5)&&(((xOne==1&&yOne==5)||(xTwo==1&&yTwo==5))))
        System.out.println(i + " |   *");
    else if((i==4)&&(((xOne==1&&yOne==4)||(xTwo==1&&yTwo==4))))
        System.out.println(i + " |   *");
    else if((i==3)&&(((xOne==1&&yOne==3)||(xTwo==1&&yTwo==3))))
        System.out.println(i + " |   *");
    else if((i==2)&&(((xOne==1&&yOne==2)||(xTwo==1&&yTwo==2))))
        System.out.println(i + " |   *");
    else if((i==1)&&(((xOne==1&&yOne==1)||(xTwo==1&&yTwo==1))))
        System.out.println(i + " |   *");
    else if((i==0)&&(((xOne==1&&yOne==0)||(xTwo==1&&yTwo==0))))
        System.out.println(i + " + — * — — — — — — — — — — — — — — — — —");
}

if(xOne==2||xTwo==2)    
{
    if((i==9)&&(((xOne==2&&yOne==9)||(xTwo==2&&yTwo==9))))
        System.out.println(i + " |       *");
    else if((i==8)&&(((xOne==2&&yOne==8)||(xTwo==2&&yTwo==8))))
        System.out.println(i + " |       *");
    else if((i==7)&&(((xOne==2&&yOne==7)||(xTwo==2&&yTwo==7))))
        System.out.println(i + " |       *");
    else if((i==6)&&(((xOne==2&&yOne==6)||(xTwo==2&&yTwo==6))))
        System.out.println(i + " |       *");
    else if((i==5)&&(((xOne==2&&yOne==5)||(xTwo==2&&yTwo==5))))
        System.out.println(i + " |       *");
    else if((i==4)&&(((xOne==2&&yOne==4)||(xTwo==2&&yTwo==4))))
        System.out.println(i + " |       *");
    else if((i==3)&&(((xOne==2&&yOne==3)||(xTwo==2&&yTwo==3))))
        System.out.println(i + " |       *");
    else if((i==2)&&(((xOne==2&&yOne==2)||(xTwo==2&&yTwo==2))))
        System.out.println(i + " |       *");
    else if((i==1)&&(((xOne==2&&yOne==1)||(xTwo==2&&yTwo==1))))
        System.out.println(i + " |       *");
    else if((i==0)&&(((xOne==2&&yOne==0)||(xTwo==2&&yTwo==0))))
        System.out.println(i + " + — — — * — — — — — — — — — — — — — — —");
}

if(xOne==3||xTwo==3)    
{
    if((i==9)&&(((xOne==3&&yOne==9)||(xTwo==3&&yTwo==9))))
        System.out.println(i + " |           *");
    else if((i==8)&&(((xOne==3&&yOne==8)||(xTwo==3&&yTwo==8))))
        System.out.println(i + " |           *");
    else if((i==7)&&(((xOne==3&&yOne==7)||(xTwo==3&&yTwo==7))))
        System.out.println(i + " |           *");
    else if((i==6)&&(((xOne==3&&yOne==6)||(xTwo==3&&yTwo==6))))
        System.out.println(i + " |           *");
    else if((i==5)&&(((xOne==3&&yOne==5)||(xTwo==3&&yTwo==5))))
        System.out.println(i + " |           *");
    else if((i==4)&&(((xOne==3&&yOne==4)||(xTwo==3&&yTwo==4))))
        System.out.println(i + " |           *");
    else if((i==3)&&(((xOne==3&&yOne==3)||(xTwo==3&&yTwo==3))))
        System.out.println(i + " |           *");
    else if((i==2)&&(((xOne==3&&yOne==2)||(xTwo==3&&yTwo==2))))
        System.out.println(i + " |           *");
    else if((i==1)&&(((xOne==3&&yOne==1)||(xTwo==3&&yTwo==1))))
        System.out.println(i + " |           *");
    else if((i==0)&&(((xOne==3&&yOne==0)||(xTwo==3&&yTwo==0))))
        System.out.println(i + " + — — — — — * — — — — — — — — — — — — —");
}

if(xOne==4||xTwo==4)    
{
    if((i==9)&&(((xOne==4&&yOne==9)||(xTwo==4&&yTwo==9))))
        System.out.println(i + " |               *");
    else if((i==8)&&(((xOne==4&&yOne==8)||(xTwo==4&&yTwo==8))))
        System.out.println(i + " |               *");
    else if((i==7)&&(((xOne==4&&yOne==7)||(xTwo==4&&yTwo==7))))
        System.out.println(i + " |               *");
    else if((i==6)&&(((xOne==4&&yOne==6)||(xTwo==4&&yTwo==6))))
        System.out.println(i + " |               *");
    else if((i==5)&&(((xOne==4&&yOne==5)||(xTwo==4&&yTwo==5))))
        System.out.println(i + " |               *");
    else if((i==4)&&(((xOne==4&&yOne==4)||(xTwo==4&&yTwo==4))))
        System.out.println(i + " |               *");
    else if((i==3)&&(((xOne==4&&yOne==3)||(xTwo==4&&yTwo==3))))
        System.out.println(i + " |               *");
    else if((i==2)&&(((xOne==4&&yOne==2)||(xTwo==4&&yTwo==2))))
        System.out.println(i + " |               *");
    else if((i==1)&&(((xOne==4&&yOne==1)||(xTwo==4&&yTwo==1))))
        System.out.println(i + " |               *");
    else if((i==0)&&(((xOne==4&&yOne==0)||(xTwo==4&&yTwo==0))))
        System.out.println(i + " + — — — — — — — * — — — — — — — — — — —");
}

if(xOne==5||xTwo==5)    
{
    if((i==9)&&(((xOne==5&&yOne==9)||(xTwo==5&&yTwo==9))))
        System.out.println(i + " |                   *");
    else if((i==8)&&(((xOne==5&&yOne==8)||(xTwo==5&&yTwo==8))))
        System.out.println(i + " |                   *");
    else if((i==7)&&(((xOne==5&&yOne==7)||(xTwo==5&&yTwo==7))))
        System.out.println(i + " |                   *");
    else if((i==6)&&(((xOne==5&&yOne==6)||(xTwo==5&&yTwo==6))))
        System.out.println(i + " |                   *");
    else if((i==5)&&(((xOne==5&&yOne==5)||(xTwo==5&&yTwo==5))))
        System.out.println(i + " |                   *");
    else if((i==4)&&(((xOne==5&&yOne==4)||(xTwo==5&&yTwo==4))))
        System.out.println(i + " |                   *");
    else if((i==3)&&(((xOne==5&&yOne==3)||(xTwo==5&&yTwo==3))))
        System.out.println(i + " |                   *");
    else if((i==2)&&(((xOne==5&&yOne==2)||(xTwo==5&&yTwo==2))))
        System.out.println(i + " |                   *");
    else if((i==1)&&(((xOne==5&&yOne==1)||(xTwo==5&&yTwo==1))))
        System.out.println(i + " |                   *");
    else if((i==0)&&(((xOne==5&&yOne==0)||(xTwo==5&&yTwo==0))))
        System.out.println(i + " + — — — — — — — — — * — — — — — — — — —");
}

if(xOne==6||xTwo==6)    
{
    if((i==9)&&(((xOne==6&&yOne==9)||(xTwo==6&&yTwo==9))))
        System.out.println(i + " |                       *");
    else if((i==8)&&(((xOne==6&&yOne==8)||(xTwo==6&&yTwo==8))))
        System.out.println(i + " |                       *");
    else if((i==7)&&(((xOne==6&&yOne==7)||(xTwo==6&&yTwo==7))))
        System.out.println(i + " |                       *");
    else if((i==6)&&(((xOne==6&&yOne==6)||(xTwo==6&&yTwo==6))))
        System.out.println(i + " |                       *");
    else if((i==5)&&(((xOne==6&&yOne==5)||(xTwo==6&&yTwo==5))))
        System.out.println(i + " |                       *");
    else if((i==4)&&(((xOne==6&&yOne==4)||(xTwo==6&&yTwo==4))))
        System.out.println(i + " |                       *");
    else if((i==3)&&(((xOne==6&&yOne==3)||(xTwo==6&&yTwo==3))))
        System.out.println(i + " |                       *");
    else if((i==2)&&(((xOne==6&&yOne==2)||(xTwo==6&&yTwo==2))))
        System.out.println(i + " |                       *");
    else if((i==1)&&(((xOne==6&&yOne==1)||(xTwo==6&&yTwo==1))))
        System.out.println(i + " |                       *");
    else if((i==0)&&(((xOne==6&&yOne==0)||(xTwo==6&&yTwo==0))))
        System.out.println(i + " + — — — — — — — — — — — * — — — — — — —");
}

if(xOne==7||xTwo==7)    
{
    if((i==9)&&(((xOne==7&&yOne==9)||(xTwo==7&&yTwo==9))))
        System.out.println(i + " |                           *");
    else if((i==8)&&(((xOne==7&&yOne==8)||(xTwo==7&&yTwo==8))))
        System.out.println(i + " |                           *");
    else if((i==7)&&(((xOne==7&&yOne==7)||(xTwo==7&&yTwo==7))))
        System.out.println(i + " |                           *");
    else if((i==6)&&(((xOne==7&&yOne==6)||(xTwo==7&&yTwo==6))))
        System.out.println(i + " |                           *");
    else if((i==5)&&(((xOne==7&&yOne==5)||(xTwo==7&&yTwo==5))))
        System.out.println(i + " |                           *");
    else if((i==4)&&(((xOne==7&&yOne==4)||(xTwo==7&&yTwo==4))))
        System.out.println(i + " |                           *");
    else if((i==3)&&(((xOne==7&&yOne==3)||(xTwo==7&&yTwo==3))))
        System.out.println(i + " |                           *");
    else if((i==2)&&(((xOne==7&&yOne==2)||(xTwo==7&&yTwo==2))))
        System.out.println(i + " |                           *");
    else if((i==1)&&(((xOne==7&&yOne==1)||(xTwo==7&&yTwo==1))))
        System.out.println(i + " |                           *");
    else if((i==0)&&(((xOne==7&&yOne==0)||(xTwo==7&&yTwo==0))))
        System.out.println(i + " + — — — — — — — — — — — — — * — — — — —");
}

if(xOne==8||xTwo==8)    
{
    if((i==9)&&(((xOne==8&&yOne==9)||(xTwo==8&&yTwo==9))))
        System.out.println(i + " |                               *");
    else if((i==8)&&(((xOne==8&&yOne==8)||(xTwo==8&&yTwo==8))))
        System.out.println(i + " |                               *");
    else if((i==7)&&(((xOne==8&&yOne==7)||(xTwo==8&&yTwo==7))))
        System.out.println(i + " |                               *");
    else if((i==6)&&(((xOne==8&&yOne==6)||(xTwo==8&&yTwo==6))))
        System.out.println(i + " |                               *");
    else if((i==5)&&(((xOne==8&&yOne==5)||(xTwo==8&&yTwo==5))))
        System.out.println(i + " |                               *");
    else if((i==4)&&(((xOne==8&&yOne==4)||(xTwo==8&&yTwo==4))))
        System.out.println(i + " |                               *");
    else if((i==3)&&(((xOne==8&&yOne==3)||(xTwo==8&&yTwo==3))))
        System.out.println(i + " |                               *");
    else if((i==2)&&(((xOne==8&&yOne==2)||(xTwo==8&&yTwo==2))))
        System.out.println(i + " |                               *");
    else if((i==1)&&(((xOne==8&&yOne==1)||(xTwo==8&&yTwo==1))))
        System.out.println(i + " |                               *");
    else if((i==0)&&(((xOne==8&&yOne==0)||(xTwo==8&&yTwo==0))))
        System.out.println(i + " + — — — — — — — — — — — — — — — * — — —");
}

if(xOne==9||xTwo==9)    
{
    if((i==9)&&(((xOne==9&&yOne==9)||(xTwo==9&&yTwo==9))))
        System.out.println(i + " |                                   *");
    else if((i==8)&&(((xOne==9&&yOne==8)||(xTwo==9&&yTwo==8))))
        System.out.println(i + " |                                   *");
    else if((i==7)&&(((xOne==9&&yOne==7)||(xTwo==9&&yTwo==7))))
        System.out.println(i + " |                                   *");
    else if((i==6)&&(((xOne==9&&yOne==6)||(xTwo==9&&yTwo==6))))
        System.out.println(i + " |                                   *");
    else if((i==5)&&(((xOne==9&&yOne==5)||(xTwo==9&&yTwo==5))))
        System.out.println(i + " |                                   *");
    else if((i==4)&&(((xOne==9&&yOne==4)||(xTwo==9&&yTwo==4))))
        System.out.println(i + " |                                   *");
    else if((i==3)&&(((xOne==9&&yOne==3)||(xTwo==9&&yTwo==3))))
        System.out.println(i + " |                                   *");
    else if((i==2)&&(((xOne==9&&yOne==2)||(xTwo==9&&yTwo==2))))
        System.out.println(i + " |                                   *");
    else if((i==1)&&(((xOne==9&&yOne==1)||(xTwo==9&&yTwo==1))))
        System.out.println(i + " |                                   *");
    else if((i==0)&&(((xOne==9&&yOne==0)||(xTwo==9&&yTwo==0))))
        System.out.println(i + " + — — — — — — — — — — — — — — — — — * —");
}

if(i==9&&(yOne!=9&&yTwo!=9))
    System.out.println(i + " |");
if(i==8&&(yOne!=8&&yTwo!=8))
    System.out.println(i + " |");
if(i==7&&(yOne!=7&&yTwo!=7))
    System.out.println(i + " |");
if(i==6&&(yOne!=6&&yTwo!=6))
    System.out.println(i + " |");
if(i==5&&(yOne!=5&&yTwo!=5))
    System.out.println(i + " |");
if(i==4&&(yOne!=4&&yTwo!=4))
    System.out.println(i + " |");
if(i==3&&(yOne!=3&&yTwo!=3))
    System.out.println(i + " |");
if(i==2&&(yOne!=2&&yTwo!=2))
    System.out.println(i + " |");
if(i==1&&(yOne!=1&&yTwo!=1))
    System.out.println(i + " |");
if(i==0&&(yOne!=0&&yTwo!=0))
    System.out.println(i + " + — — — — — — — — — — — — — — — — — — —");
}



System.out.println("  0   1   2   3   4   5   6   7   8   9");
}

}