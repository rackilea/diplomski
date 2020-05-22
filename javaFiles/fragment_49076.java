public class QuaternionExample {
    public static void main(String[] args) {
        /*
         * Let's say we have a vector <1,0,0>, and we want to rotate it
         * such that the result will be in the other unit axiis: <0,1,0>
         * and <0,0,1>.  Right hand rule applies for rotating about an axis!
         * Convince yourself of the following through mental imagery:
         * 1. For <0,1,0>, we want to rotate <1,0,0> by 90 degrees about the z axis
         * 2. For <0,0,1>, we want to rotate <1,0,0> by 90 degrees about the -y axis (or -90 degrees also works)
         */

        //the quaternion form of a 3d vector is simply <0,Vec3> or <0,x,y,z>
        Quaternion x=new Quaternion(); 
        x.set(0,1,0,0);

        //1, we want <0,1,0>
        Quaternion rot = new Quaternion(Math.PI/2,0,0,1);
        System.out.println( rot.mult(x).mult(rot.conj()) );

        //2, we want <0,0,1>
        rot = new Quaternion(Math.PI/2,0,-1,0);
        System.out.println( rot.mult(x).mult(rot.conj()) );
        rot = new Quaternion(-Math.PI/2,0,1,0);
        System.out.println( rot.mult(x).mult(rot.conj()) );
    }
}