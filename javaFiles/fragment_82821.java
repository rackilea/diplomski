import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BudgetMain {


    public static void main(String[] args){
        Stack<Double> stack = new Stack<>();
        stack.push(1.0);
        stack.push(2.0);
        addExpenditure1(stack, new File("test.out"));
    }


    public static void addExpenditure1(Stack<Double> costStack, File f){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f.getPath(), true))) {

            while (costStack.size() != 0)
                bw.write(costStack.pop().toString() + " ,");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}