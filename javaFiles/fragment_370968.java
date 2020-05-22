public class One
    {
       public static Loots[] lootsList = new Loots[1];
    }   

    public class Two
    { 
       Loots MyLoots = new Loots();         
       // How to add in THIS class, MyLoots to lootsList? 
       One.Loots[0]=MyLoots; //use this to access array of objects
    }