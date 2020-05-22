public class Service {

    private NonStaticClass nonStatic;

    public NonStaticClass getNonStatic() {
        return nonStatic;
    }

    public void setNonStatic(NonStaticClass nonStatic) {
        this.nonStatic = nonStatic;
    }

    public int useStaticService () {
        return 2*StaticClass.staticMethod();
    }

    public Integer getLastUse () {
        return this.nonStatic.getLastUse();
    }
}