package user_package;

    public class Point {
        float x;
        float y;
        float z;

        public Point(float x, float y, float z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public static Point add(Point p1, Point p2){
            return new Point(p1.x + p2.x, p1.y + p2.y, p1.z + p2.z);
        }

        @Override
        public String toString() {
          StringBuilder result = new StringBuilder();
             result.append(this.x).append(",");  
             result.append(this.y).append(",");
             result.append(this.z)
             return result.toString();
        }
    }