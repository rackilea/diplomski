public class Scene extends View{
  private List<Explosions> explosions = new ArrayList<Explosions>();
  @Override
  public void onDraw(){
     //obviously i have a concurrency issue here.. meh
     for (Explosions e:explosions){
     /// draw your explosions here

     }

  }

  public void addExplosion(Explosions x){
       explosions.add(x)
  }
}