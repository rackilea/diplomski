import java.io.IOException; 
import java.io.*;
import java.util.Scanner;
public class Lab2
{ 
    public static void main(String[] args) throws IOException
    { String FirstName, LastName, Address1, Address2, Address3, AddressFull, City, State, Phone, ZipString, DonString, line = "blank";
      int Zip;
      double Donation;

      Scanner fileScan = new Scanner(new File("F:/test.txt")).useDelimiter("\n");

      PersonStats[] Donators = new PersonStats[5];
      String tempVal="";
      int i = 0;
      while(fileScan.hasNext())
      {
        tempVal = fileScan.next();  //Storing person records one at a time in the string line by line
        String tempArr[] = tempVal.split("\t"); //Splitting each person record string by tab and storing it in a String array

            FirstName = tempArr[0];
            LastName = tempArr[1];

            Address1 = tempArr[2];
            Address2 = tempArr[3];
            Address3 = tempArr[4];
            AddressFull = Address1 + " " + Address2 + " " + Address3;

            City = tempArr[5];
            State = tempArr[6];

            ZipString = tempArr[7];
            Zip = Integer.parseInt(ZipString);

            Phone = tempArr[8];

            DonString = tempArr[9];
            Donation = Double.parseDouble(DonString);
            Donators[i] = new PersonStats(FirstName, LastName, AddressFull, City, State, Zip, Phone, Donation);
            Donators[i].PrintOut();
            i++;
      }  
    }
}