import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(reader);

        String inputValues;
        String[] person;
        List<String> lastname = new ArrayList<String>();
        List<String> firstname = new ArrayList<String>();
        List<String> id = new ArrayList<String>();

        while(true){
            inputValues = input.readLine();
            person = inputValues.split("\\s+");
            if(inputValues.equals("exit")){
              break;
            }else{
                lastname.add(person[0]);
                firstname.add(person[1]);
                id.add(person[2]);
            }
        }

        for(int i=0; i<lastname.size(); i++)
            System.out.println(firstname.get(i) +" "+ lastname.get(i) +" ("+ id.get(i) +")");
    }
}