import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner vloz = new Scanner(System.in);
    int cisla = 0;
    int i = 0;
    while(i < 10){
      try {
        System.out.print("Vloz cislo " + i + ":");
        int cislo = Integer.parseInt(vloz.nextLine());
        i++;
        cisla = cisla + cislo;
      } catch(NumberFormatException exception) {
        System.out.println("Nevlozil si cislo!");
      }
    }
    float priemer = cisla / i;
    System.out.println("Priemer cisel je " + priemer + ".");
  }   
}