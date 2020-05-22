import java.io.*;
import java.util.ArrayList;

public class A3Q1 {
    public static void main(String[] args){
        BufferedReader input;
        String line;
        String command, name = null;
        int quantity = 0;
        //Groceries name;
        String tokens[];

        ArrayList<Groceries> shoppingList = new ArrayList<>();
        ArrayList<Groceries> purchaseList = new ArrayList<>();
        Groceries grocery = null;


        try{
            input = new BufferedReader(new FileReader("a3a.txt"));
            line = input.readLine();
            while(line!= null){
                tokens = line.split(",");
                command = tokens[0].trim();

                if(command.equals("list")) {
                  System.out.println("shoppingList " + shoppingList);
                  System.out.println("purchaseList " + purchaseList);
                  System.out.println("");
                } else {
                  quantity = Integer.parseInt(tokens[1].trim());
                  name = tokens[2].trim();
                }

                if (command.equals("add")) {
                  boolean added = false;
                  for (int i=0; i<shoppingList.size(); i++) {
                    Groceries g = (Groceries) shoppingList.get(i);
                    if( g.getName().equals(name) ){
                      shoppingList.remove(g);
                      quantity += g.getQuantity();
                      g.setQuantity(quantity);
                      shoppingList.add(g);
                      added = true;
                      break;
                    }
                  }
                  if( !added ) {
                    shoppingList.add(new Groceries(quantity,name));
                  }
                }
                if (command.equals("buy")) {
                  for (int i=0; i<shoppingList.size(); i++) {
                    Groceries g = (Groceries) shoppingList.get(i);
                    if( g.getName().equals(name) ){
                      shoppingList.remove(g);
                      if( g.getQuantity() - quantity > 0 ) {
                        g.setQuantity(g.getQuantity() - quantity);
                        shoppingList.add(g);
                      } else {
                        //quantity = g.getQuantity(); //removed this as you wanted to keep the purchaselist this way
                      }
                      break;
                    }
                  }

                  boolean added = false;
                  for (int i=0; i<purchaseList.size(); i++) {
                    Groceries g = (Groceries) purchaseList.get(i);
                    if( g.getName().equals(name) ){
                      purchaseList.remove(g);
                      quantity += g.getQuantity();
                      g.setQuantity(quantity);
                      purchaseList.add(g);
                      added = true;
                      break;
                    }
                  }
                  if( !added ) {
                    purchaseList.add(new Groceries(quantity,name));
                  }
                }
                line = input.readLine();
            }

        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}

class Groceries {
    private String name;
    private int quantity;


    public Groceries( int quantity, String name){
        this.name =name;
        this.quantity=quantity;
    }

    public String getName() {
      return name;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) { this.quantity=quantity; }

    public String toString() {
      return quantity + ", " + name;
    }
}