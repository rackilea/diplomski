public abstract class Animal {
    private int size;

    public Animal() {
        size = -1;
    }

    public Animal(int size) {
        this.size = size;
    }

    public void setSize( int size ) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static void main(final String[] args) {

      Animal[] animals  = new Animal[2];
      animals[0] = new Liger(20);
      animals[1] = new Liger();

      for(int i = 0; i < animals.length; ++i) {
          System.out.println("Size : " + animals[i].getSize());
      }   
    }
}

public class Tiger extends Animal {
      public Tiger() {
         super();    
      }

      public Tiger(int size) {
         super(size);
      }
}

public class Liger extends Animal {
      public Liger() {
         super();    
      }

      public Liger(int size) {
         super(size);
      }  
}