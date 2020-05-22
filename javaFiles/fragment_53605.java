public class Main{

    public static void main(String[] args) {
        Vector3d vectorTest=new Vector3d(1,2,3);
        System.out.println(vectorTest.x); //prints 1
        affectVector(vectorTest);
        System.out.println(vectorTest.x); //prints 100
        replaceVector(vectorTest);
        System.out.println(vectorTest.x); //still prints 100
    }

    public static void affectVector(Vector3d vectorIn){
         vectorIn.x=100; 
    }

    public static void replaceVector(Vector3d vectorIn){
         //this method has no external effect because the reference vectorIn is immediately overrwritten
         vectorIn=new Vector3d(0,0,0); //the reference vectorIn is completely changed
    }


}