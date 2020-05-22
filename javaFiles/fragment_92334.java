import  java.util.*;

class Data

{

    double r;
    public void gdata()

    {

        System.out.println("Enter Radius");
        Scanner s = new Scanner(System.in);
        r=s.nextFloat();
    }

}

class Area extends Data

{

    double area;
    public void calculate()
    {area = r*r*3.14;}
    public void display()

    {

        this.gdata();
        this.calculate();
        System.out.println("Area of Circle= "+area);}

}


class  Volume extends Area

{

    final double pi=3.141;
    double v;
    public void calculate()
    {v=(4*r*r*r*pi)/3;}
    public void display()

    {

        this.gdata();
        this.calculate();
        System.out.println("Volume of Sphere= "+v);}

}


class Postlab

{

    public static void main(String args[])

    {

        Area obj1 = new Area();
        Area obj2 = new Volume();
        obj1.display();
        obj2.display();

    }

}