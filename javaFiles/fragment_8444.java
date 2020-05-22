public class ShapeMain {

    public static void main(String[] args) {

        // Your code uses this approach
        Sphere1 s1 = new Sphere1();
        s1.volume(2.0);

        // An improvement to above
        Sphere2 s2 = new Sphere2(2.0);
        s2.volume();

        // An better alternative if you want stateless classes
        Sphere3.volume(2.0);

    }

    //  Models your class; has NO state 
    static class Sphere1 {
        double volume(double r) {
            return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
        }
    }

    //  A class with state (radius) 
    static class Sphere2 {
        private final double r;
        public Sphere2(double r) {
            this.r = r;
        }
        double volume() {
            return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
        }
    }

    //  A class with no state; use a static method to calculate Sphere volume
    static class Sphere3 {
        static double volume(double r) {
            return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
        }
    }

    }