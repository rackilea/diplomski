int age;
int weight;
int id;

Exceptiontest(int sAge, int sWeight, int sId)
{
  age = sAge;
  weight = sWeight;
  id = sId;
}

public String toString()
{
   return "\nWalter #" + id + "\nAge: " + age + "\nWeight: " + weight + "\n";
}

public static String fight(Exceptiontest aWalter,Exceptiontest bWalter)
{
    if(aWalter.age > bWalter.age)
    {       
    return "The winner is #1";
    }
    else
    {
    return "The winner is #2";
    }

}

public static void main (String[]args)
{
  Exceptiontest a = new Exceptiontest(20,75,1);
  Exceptiontest b = new Exceptiontest(10,25,2);
  Exceptiontest c = new Exceptiontest(1,7,3);



   System.out.println(fight(a,b));

}