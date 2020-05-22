import java.util.ArrayList;
import java.util.Scanner;

public class Complex {
    Double real=0d;
    Double complex=0d;
    Complex(Double real, Double complex){
        this.real=real;
        this.complex=complex;
    }
    Complex(){
    }
    public void setReal(Double real){
        this.real=real;
    }
    public void setComplex(Double complex){
        this.complex=complex;
    }
    public Double getReal(){
        return real;
    }
    public String getComplex(){
        return complex+"i";
    }
    public String toString(){
        if (real==0d)
            return complex+"i";
        else if (complex==0d)
            return real+"";
        else
        return real+" + "+complex+"i";
    }
    static ArrayList<Complex> complexList=new ArrayList<Complex>();
    public static void createComplex(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Type the complex numbers; Type Done to finish!");
        String x=scanner.next();

        while (!x.equals("Done")){
           // System.out.println(x);
            Complex no=new Complex();
            //check if the user has inputted only one number
            if (!x.contains("+")&&!x.contains("i")){
                no.setReal(Double.parseDouble(x));
                x= scanner.next();
                //ask for the second number; no wrong input checks
                no.setComplex(Double.parseDouble(x));
            }
            //check if the user inputted something like 123.3i
            else if (!x.contains("+")&&x.contains("i")){
                //create the complex number; replace i with ""
                x=x.replace("i","");

               // System.out.println(x);
                no.setComplex(Double.parseDouble(String.valueOf(x)));
            }
            else{
               //else remove the + sign and create a complex number
               //input like 123.3+32i
               //no wrong input checks
               x= x.replaceAll("\\s+","");
                String[] tokens = x.split("\\+");
                no.setReal(Double.parseDouble(String.valueOf(tokens[0])));
                tokens[1]=tokens[1].replace("i","");
                no.setComplex(Double.parseDouble(String.valueOf(tokens[1])));
            }
            //ask for next input until Done is typed
            x=scanner.next();
            complexList.add(no);
        }
    }

    public static void main(String[] args) {
        createComplex();
        for (Complex x:complexList){
            System.out.println(x.toString());
        }
    }

}