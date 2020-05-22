import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        System.out.println("What's your name?");
        Scanner scan = new Scanner(System.in);

        String name;
        name = scan.next();

        System.out.println("Hello " + name);

            HashSet<String> setOfvehicles = new HashSet<String>(); //List will have duplicate values, so if you use set it want have duplicate, Easy to remove
            setOfvehicles.add("Ferrari La Ferrari");
            setOfvehicles.add("Lamborghini Huracan");
            setOfvehicles.add("Ducati 1199 Panigale");
            setOfvehicles.add("Porshe 918");
            setOfvehicles.add("McLaren P1");
            setOfvehicles.add("Pagani Zonda F");
            setOfvehicles.add("BMW M3 E92");
            setOfvehicles.add("Audi R8");
            setOfvehicles.add("Peugeot Oxia");
            setOfvehicles.add("Citroen DS 5");

            System.out.print("Now you have " + setOfvehicles.size());
            System.out.println(" cars in the garage.");
            System.out.println("");

            System.out.println("ADD - to add vehicle."); //Add description
            System.out.println("REMOVE - to delete vehicle."); //REMOVE description
            System.out.println("STATUS - to check current state of slots ."); //STATUS description
            System.out.println("EXIT - to exit.");//EXIT description
            System.out.println("ADD/REMOVE/STATUS/EXIT");//Your system ask ADD/REMOVE/STATUS/EXIT form user
            String userInput = scan.nextLine(); //user first input store here

            while(userInput.compareToIgnoreCase("EXIT") != 0){ //Until user input is EXIT you will ask for input
                if (userInput.compareToIgnoreCase("ADD") == 0) { //If user input is ADD
                    System.out.println("Type name of vehicle: ");//Ask for vehicle name to be add
                    String vehicleName = scan.nextLine();
                    setOfvehicles.add(vehicleName);
                } else if(userInput.compareToIgnoreCase("STATUS") == 0){//If user input is STATUS
                    for(String setOfvehicle :setOfvehicles){
                        System.out.println(setOfvehicle);
                    }
                } else if(userInput.compareToIgnoreCase("REMOVE") == 0){//If user input is REMOVE
                    System.out.println("Type name of vehicle to be removed: ");//Ask for vehicle name to be remove
                    String vehicleName = scan.nextLine();
                    setOfvehicles.remove(vehicleName);
                }
                System.out.println("ADD/REMOVE/STATUS/EXIT");//Your system ask ADD/REMOVE/STATUS/EXIT form user
                userInput = scan.nextLine();//user next input store here
            }

            System.out.println("");
            System.out.print("Currently you have " + setOfvehicles.size());
            System.out.println(" cars in the garage");
            System.out.println("");
            scan.close();
        }
    }