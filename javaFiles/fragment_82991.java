public class Test {
    public static void main(String[] args) {
        Human<Blond, Bob> h = new Human<Blond, Bob>();
        Blond blond = h.getPerson().getHair(); 
        blond = h.getDirectHair();
    }
}

class Human<H extends Hair, T extends Person<H>>{
    private T person = null;
    public T getPerson() {
        return person;
    }
    public H getDirectHair(){
        return person.getHair();
    }
}