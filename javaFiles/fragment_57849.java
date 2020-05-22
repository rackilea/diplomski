public class TestingforExcel {
    static String tableholder = "2 * 3 * 4 * 5 / 2 / 3 / 2";
    public static void main(String args[]){
         String[] fracEquationHolder = tableholder.split(" ",tableholder.length()); // holds the fractions and operator
        String operators = "";
        double operand;
        double operand2;
        double answer = Double.parseDouble(fracEquationHolder[0]);

        for(int i =0; i <= (fracEquationHolder.length-2); i+=2){
            operators = fracEquationHolder[i+1];
            operand = Double.parseDouble(fracEquationHolder[i]);
            operand2 = Double.parseDouble(fracEquationHolder[i+2]);
            if(operators.indexOf("+")>=0){
                answer += operand2;
            }else if(operators.indexOf("-")>=0){
                answer -= operand2;
            }else if(operators.indexOf("*")>=0){
                answer *=  operand2;
            }else if(operators.indexOf("/")>=0){
                answer /=   operand2;
            }else
                System.out.print(answer+""); 
        }
        System.out.print(answer+""); 

    }