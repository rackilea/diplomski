package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostFixCalculator {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String expression;

    System.out.println("Student name, CS-304, Fall 2014, Asst 2c.");

    System.out.println("To quit this program, just hit 'return'.\n");

    System.out.print("Enter a postfix expression: ");
    expression = kbd.nextLine();

    while (!expression.equals("")) {
        try {
            System.out.println(postFixEvaluate(expression));
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.print("\nEnter a postfix expression: ");
        expression = kbd.nextLine();

    } // end while (!expression.equals(""))

    System.out.println("\nBye!");
    kbd.close();

  } 

  public static String postFixEvaluate(String input)
  {

  List<String> operatorsAsStrings = getListOfValuesAsString(input.split("\\d+"));
  List<String> digitsAsStrings = getListOfValuesAsString(input.split("\\W+"));


  if(operatorsAsStrings.size() >= digitsAsStrings.size()){
      throw new RuntimeException("Incorrect format of expression.");
  }

  if(digitsAsStrings.size()<2){
      throw new RuntimeException("Not Enough Operands.");
  }

  BigInteger result = new BigInteger("0");
  boolean firstTime = true;

  for (int i=0; i<=digitsAsStrings.size()-1; i++) {

      if(firstTime){
          result = result.add(new BigInteger(digitsAsStrings.get(i)));
          firstTime = false;

      }else{

          String operator = operatorsAsStrings.get(i-1);
          if (operator.equals("+"))
              result = result.add(new BigInteger(digitsAsStrings.get(i)));
          else if (operator.equals("-"))
               result = result.subtract(new BigInteger(digitsAsStrings.get(i)));
          else if (operator.equals("*"))
               result = result.multiply(new BigInteger(digitsAsStrings.get(i)));
          else if (operator.equals("/"))
               result = result.divide(new BigInteger(digitsAsStrings.get(i)));

      }

  }
  return result.toString(); 
 } 

 private static List<String> getListOfValuesAsString(String[] split) {
    List<String> resultList = new ArrayList<>();

    for(String string: split){
        if(string != null && !string.isEmpty()){
            resultList.add(string);
        }
    }

    return resultList;
 }
}