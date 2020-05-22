private transient Booleans opposite;

static class BooleansOpposite extends Booleans {
     Booleans original;

     BooleansOpposite(Booleans original) {
         super(null);
         this.original = original;
     }

     public Booleans opposite() {
         return original;
     }

     public boolean getDataAt(int i) {
          return !original.getDataAt(i);
     }
}

public Booleans opposite() {
    if (opposite == null) {
        opposite = new BooleansOpposite(this);
    }
    return opposite;
}