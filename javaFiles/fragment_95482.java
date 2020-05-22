public class Adder {
    public static void main(String[] args) {
        //Array to hold the two inputted numbers
        float[] num = new float[2];
        //Sum of the array [2] will be stored in answer
        float answer = 0;

        /*
            some how need to check the type of agruments entered...
        */

        //If more than two agruments are entered, the error message will be shown
        if (args.length > 2 || args.length < 2){
            System.out.println("ERROR: enter only two numbers not more not less");
        }

        else{
            try {
                //Loop to add all of the values in the array num 
                for (int i = 0; i < args.length; i++){
                    num[i] = Float.parseFloat(args[i]);
                    //adding the values in the array and storing in answer
                    answer += Float.parseFloat(args[i]);
                }

                System.out.println(num[0]+" + "+num[1]+" = "+answer);
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: enter only numeric values");
            }
        }
    }
}