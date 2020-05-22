import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class Ingredients {

    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //or Scanner scan = new Scanner(System.in);
        int ingredientID=0;
        int sumOfIngredients=0;


        System.out.println("Keep selecting the ingrients that you want until you press (0)");

        //use do while to make it run at least once
        do{
            //get input, add to sumofIngredients
            ingredientID=Integer.parseInt(br.readLine());
        //or ingredientID= scan.nextInt(); if you're using scanner

            //add the ingredient
            sumOfIngredients+=ingredientID;

       //I don't think you need to ask "one more?". 
//You have given the instruction (to keep selecting the ingredients till the user presses 0 )
        }while(ingredientID!=0);

            //print the ingredients!
        System.out.println("sum of ingredients: "+ sumOfIngredients);           
    }
}