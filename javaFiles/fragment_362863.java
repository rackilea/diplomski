public enum Layout {
    CHARGE("Charge", false, false) {

        @Override
        public String blazon(CoatOfArms paramCoatOfArms) {
            // ...
        }

        @Override
        public void draw(CoatOfArms paramCoatOfArms, MyDraw paramMyDraw, double paramDouble1, double paramDouble2, double paramDouble3) {
            // ...
        }

        @Override
        public void drawLayout(MyDraw paramMyDraw, double paramDouble1, double paramDouble2) {
            // ...
        }

    },

    FESS("Fess", true, true) {

       @Override
       public String blazon(CoatOfArms paramCoatOfArms) {
           // ...
       }

       @Override
       public void draw(CoatOfArms paramCoatOfArms, MyDraw paramMyDraw, double paramDouble1, double paramDouble2, double paramDouble3) {
            // ...
       }

       @Override
       public void drawLayout(MyDraw paramMyDraw, double paramDouble1, double paramDouble2) {
           // ...
       }

    }

    /*
     rest of the constants, each implementing the methods
     */ ;

    public final String name;
    public final boolean hasSecondary;
    public final boolean chargeInSecondary;

    public abstract String blazon(CoatOfArms paramCoatOfArms);

    public abstract void draw(CoatOfArms paramCoatOfArms, MyDraw paramMyDraw, double paramDouble1, double paramDouble2, double paramDouble3);

    public abstract void drawLayout(MyDraw paramMyDraw, double paramDouble1, double paramDouble2);

    private Layout(String name, boolean hasSecondary, boolean chargeInSecondary) {
        this.name = name;
        this.hasSecondary = hasSecondary;
        this.chargeInSecondary = chargeInSecondary;
    }
}