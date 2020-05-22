import java.util.*;

        public class Tri {

        public static void main(String []args){

            Triangle t1 = new Triangle(7, 5, 4);
            Triangle t2 = new Triangle(9, 6, 1);

            System.out.println(t1.perimeter());
            System.out.println(t2.perimeter());

            ArrayList<Triangle>allTriangles = new ArrayList<Triangle>();
            allTriangles.add(t1);
            allTriangles.add(t2);

            System.out.println(totalPerimeter(allTriangles));

        }

        public static double totalPerimeter( ArrayList<Triangle>a ){

            double tp = 0.0;

            for(Triangle t : a) {
                System.out.println( "peri : " +  t.perimeter());
                tp += t.perimeter();

            }

            return tp;

        //    for( int i = 0; i < a.length; i++){
        //
        //        System.out.println( a.perimeter[i]);
        //
        //    }
        }


        static class Triangle{

            public Triangle( double a, double b, double c ){

                this.sideA = a;
                this.sideB = b;
                this.sideB = c;

                if (checkSides() == true){}
            }

            public double getA(){
                return sideA;
            }

            public double getB(){
                return sideB;
            }

            public double getC(){
                return sideC;
            }

            public Triangle setA( double a ){

                sideA = a;
                return this;

            }

            public Triangle setB( double b ){

                sideB = b;
                return this;

            }
            public Triangle setC( double c ){

                sideC = c;
                return this;
            }

            public String toString(){

                return "Perimeter of triangle is " + perimeter;
            }

            public double perimeter(){

                if (checkSides() == true)

                perimeter = (sideA+sideB+sideC);
                return perimeter;

            }

        private boolean checkSides(){

                    if (!(sideA+sideB>sideC) && (sideA+sideC>sideB) && (sideB+sideC>sideA)){
                        die("Not valid sides of triangle.");
                        return false;
                    }

                    else return true;

                }

                public void die( String msg ){
                    System.err.println( "\nFatal error: " + msg );
                    System.exit( 1 );
                }

                private double perimeter;
                private double sideA;
                private double sideB;
                private double sideC;
        }
        }