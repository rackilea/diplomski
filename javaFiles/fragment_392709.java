public class Que01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int principle=acceptInt(sc,"Principle");
        int roi=acceptInt(sc,"Rate Of Interest");
        int years=acceptInt(sc,"Years");
        sc.close();
        float si=simpleInterest(principle,roi,years);

        System.out.println("Simple Interest for given details is : "+si);
    }

    static int acceptInt(Scanner sc,String s1)
    {   System.out.println("Please Enter value for "+s1+" :");

        int i= sc.nextInt();
        return i;
    }
    static float simpleInterest(int p,int r, int yr)
    {
        return p*yr*r/100;
    }

}```