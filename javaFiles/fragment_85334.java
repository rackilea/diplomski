public interface Cal {
   int plus(int a, int b);
}

public class CalBuilder {
    class InternalCal implements Cal {
       boolean useAbs;
       boolean checkArgs;
       public int plus(int a, int b) {
          if(checkArgs) {
             // blah, blah blah
          }
          if(useAbs) {
             // doodle bug, doodle darn
          }
          return a+b; // whatevs
       }
    }
    boolean absSet=false;
    InternalCal holder=new InternalCal();
    public CalBuilder useNormal() {
        if(absSet) { throw new IllegalArgumentException(); } // already called
        holder.useAbs=false;    
        absSet=true;
        return this;
    }

    public CalBuilder useAbs() {
        if(absSet) { throw new IllegalArgumentException(); } // already called
        holder.useAbs=false;    
        absSet=true;
        return this;
    }

    public CalBuilder checkArguments() {
       if(holder.checkArgs) { throw new IllegalArgumentException(); }
       holder.checkArgs=true;
       return this;
    }

    public Cal build() {
       return holder;
    }
}