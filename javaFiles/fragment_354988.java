public class Test {

        public static void useExtraMethod(Vector3d vector) {
            useExtraMethod(new Vector3dPlus(vector));
        }

        public static void useExtraMethod(Vector3dPlus plus){
             System.out.println(plus.extraMethod());
        }

        public static void main(String[] args) {
           Vector3d basic=new Vector3d(1,2,3);
           useExtraMethod(basic); // this line works now
        }
    }