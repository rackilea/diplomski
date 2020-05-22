public class Father{

    public void display(){
             //print father
        }

    public void hello(){
             //print father
        }
    }
}

public class Son extends Father{
      @Override
      //the annotation isn't an obligation it's just more 'clean'
      public void display(){
             //print son
      }
}