public class Testers
{

 public double method1()
{

 //You are calling super.getPowerLv1() * super.getSystemCrasher()
 //return super.getPowerLvl()*super.getSystemCrasher();
 // remove the super keyword like and call method from powerfuls getPowerLv1() and getSystemCrasher
 return powerfulS.getPowerLvl()* powerfulS.getSystemCrasher();

} 

 public static powerfulS=new powerfuls({
    public double method1()
      {
           //here you can ovverride this method how you will like
        return super.getPowerLvl()*super.getSystemCrasher() + 1 + 1;

      }
 }); 

 [..]

}