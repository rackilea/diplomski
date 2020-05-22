public class EnumTest {
    enum Animals { DOG, FISH, GOAT };

    public void test(){
        Animals a1 = Animals.DOG;
        Animals a2 = a1.DOG; // the same as Animals.DOG, but makes code messy
        Animals a3 = a1.DOG.FISH; // WTF chaining???
    }
}