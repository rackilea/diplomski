import java.util.Scanner; 
public class Automata {
public static void main(String[] args) {

Boolean keeprunning = true;
while(keeprunning){
    Scanner inputScanner = new Scanner(System.in);
    System.out.println("Please enter your input");
    String input = inputScanner.next();
    char [] Inputted = input.toCharArray();

    if (input.equalsIgnoreCase("Exit")){
        keeprunning = false;
        System.out.println("Exit now");
    }
    else{

    String stateA = "A";
    String stateB = "B";
    String stateC = "C";
    String stateD = "D";
    String stateE = "E";
    String stateF = "F";
    String currentState = "A";


    for (int i = 0; i < Inputted.length; i++){
        if (Inputted[i]=='a' && currentState.equals(stateA)){
            currentState = "B";
            System.out.println(stateA + " -- " + Inputted[i] + " --> " + stateB);
        } else if (Inputted[i]=='b' && currentState.equals(stateA)){
            currentState = "F";
            System.out.println(stateA + " -- " + Inputted[i] + " --> " + stateF);
        } 

        else if (Inputted[i] == 'a' && currentState.equals(stateB)){
            currentState = "B";
            System.out.println(stateB + " -- " + Inputted[i] + " --> " + stateB);
        } else if (Inputted[i] == 'b' && currentState.equals(stateB)){
            currentState = "C";
            System.out.println(stateB + " -- " + Inputted[i] + " --> " + stateC);
        } 

        else if (Inputted[i]== 'b' && currentState.equals(stateF)){
            currentState = "F";
            System.out.println(stateF + " -- " + Inputted[i] + " --> " + stateF);
        } else if (Inputted[i] == 'a' && currentState.equals(stateF)){
            currentState = "B";
            System.out.println(stateF + " -- " + Inputted[i] + " --> " + stateB);
        } 

        else if (Inputted[i] == 'a' && currentState.equals(stateC)){
            currentState = "D";
            System.out.println(stateC + " -- " + Inputted[i] + " --> " + stateD);
        } else if (Inputted[i] == 'b' && currentState.equals(stateC)){
            currentState = "F";
            System.out.println(stateC + " -- " + Inputted[i] + " --> " + stateF);
        } 

        else if (Inputted[i] == 'a' && currentState.equals(stateD)){
            currentState = "B";
            System.out.println(stateD + " -- " + Inputted[i] + " --> " + stateB);
        } else if (Inputted[i] == 'b' && currentState.equals(stateD)){
            currentState = "E";
            System.out.println(stateD + " -- " + Inputted[i] + " --> " + stateE);
        } 

        else if (Inputted[i] == 'a' && currentState.equals(stateE)){
            currentState = "B";
            System.out.println(stateE + " -- " + Inputted[i] + " --> " + stateB);
        } else if (Inputted[i] == 'b' && currentState.equals(stateE)){
            currentState = "C";
            System.out.println(stateE + " -- " + Inputted[i] + " --> " + stateC);
        }   

    } if (currentState.equals(stateA) || currentState.equals(stateB) || currentState.equals(stateD) || currentState.equals(stateE)){
        System.out.println("Input accepted");

    } else if (currentState.equals(stateF) || currentState.equals(stateC)){
        System.out.println("Input not accepted");
    }
}   

}
}
}