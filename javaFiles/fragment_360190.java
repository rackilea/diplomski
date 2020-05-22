import java.util.*;
    import java.io.*;

    public class Temperatura {
        private static double temp;
        private static String scala;

        //Costruttori

        public Temperatura(){
            temp=0;
            scala="C";
        }

        public Temperatura(double gradi){
            setGradi(gradi);
            scala="C";
        }

        public Temperatura(String scalagradi){
            temp=0;
            setScala(scalagradi);
        }

        public Temperatura(double gradi, String scalagradi){
        setGradi(gradi);
        setScala(scalagradi);
        }

        //Metodi set

        private void setGradi(double gradi){
            temp=gradi;
        }

        private void setScala(String scalagradi){
            if (!(scalagradi.equalsIgnoreCase("C") || scalagradi.equalsIgnoreCase("F"))){
                System.out.println("Puoi usare solo le lettere C (Celsius) ed F (Fahrenheit) per indicare la temperatura. ");
                System.exit(0);
            }
            scala = scalagradi;
        }

        private void setTemp(double gradi, String scalagradi){
            setGradi(gradi);
            setScala(scalagradi);
        }

        //Metodi get

        public double getCelsius(){
            if (scala.equalsIgnoreCase("C")){
                return temp;
            }
            return (5*(temp-32)/9);
        }

        public double getFahrenheit(){
            if (scala.equalsIgnoreCase("F")){
                return temp;
            }
            return ((9*(temp)/5)+32);
        }
    }