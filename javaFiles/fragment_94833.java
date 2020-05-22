public class Point {    

        private double x;
        private double y;
        private double z;    

        //Constructor
        Point(double l,double m,double n){

            this.x = l;
            this.y = m;
            this.z = n;         

        }

    //main method
    public static void main (String[] args){

        Point point1 = new Point(5, 10, 20);

        Point point2 = new Point(0, 5, 10); 

       //Object that is created with the greater value
        Point point3 = comparePoints(point1,point2);

        System.out.println("-----The greater value of property, "
                + "between the two compared objects is as below----");

        System.out.println("x ="+point3.x);
        System.out.println("y ="+point3.y);
        System.out.println("z ="+point3.z);

    }


    //Compare method declared static, for the satic main method to access
    public static Point comparePoints(Point a, Point b){    

        System.out.println("Values in Object a = "+a.x+""+a.y+""+a.z);

        System.out.println("Values in Object a = "+b.x+""+b.y+""+b.z);

        System.out.println("Point a has the bigger x-value");

        Point h = new Point(0,0,0);     

        if (a.x < b.x){
            h.x = b.x;
        }
        else{
            System.out.println("Point a has the bigger x-value");
            h.x = a.x;
        }

        if (a.y < b.y){
            System.out.println("Point b has the bigger y-value");
            h.y = b.y;
        }
        else{
            System.out.println("Point a has the bigger y-value");
            h.y = a.y;
        }

        if (a.z < b.z){
            System.out.println("Point b has the bigger z-value"+b.z);
            h.z = b.z;
        }
        else{
            System.out.println("Point a has the bigger z-value"+a.z);
            h.z = a.z;
           }

        return h;

    }

}