import java.io.*;
public class Car {

    public static void main(String args[]) throws Exception {
        System.out.println("The parts of a car are as follows");

        Engine engine=new Engine(); //we must create any components we have
        Bonet bonet=new Bonet(); //we must create any components we have

        for (int i = 0; i <bonet.str.length; i++) { 
            System.out.println(i +":"+ bonet.str[i]);
        }
        for (int j = 0; j < engine.ch.length; j++) {
            System.out.println(j +":"+ engine.ch[j]);
        }
        DataInputStream dis = new DataInputStream(System.in);
        System.out.println("Choose and enter any part name to group it under following                       categories:" + "\n" + "Engine" + "\t" + "\t" + "Bonet");
        String part = dis.readLine();

        boolean isInEngine=false; //assume isn't in engine, try to prove otherwise

        for(int i=0;i<engine.ch.length;i++){
            if (engine.ch[i].equals(part)){
                isInEngine=true;
            }
        }

        if (isInEngine==true) {
            System.out.println("Your choosen part is " + part + " and it comes under Engine category");
        } else {
            System.out.println("Your choosen part is " + part + " and it comes under Bonet category");
        }
    }
}

class Engine {
    String ch[] = {"asd", "fgh"};
}

class Bonet {
    String str[] = {"qwe", "rty"};
}