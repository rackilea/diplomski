public class Animal {

   private Shoutable shoutable;  
   private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void shout() {
        shoutable.shout();
    }

    public String getName() {
        return name;
    }

    public void setShout(Shoutable shoutable){
       this.shoutable=shoutable;
    }
}


public interface Shoutable{
  void shout();
}

public class DogShout implements Shoutable{
  @Override
  public void shout{
   System.out.println("woff gua guaa gua woff");
  }
}