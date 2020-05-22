public class Entity<E extends Entity<E>> {
    private static int lastID = 0;
    protected int ID;

    protected Entity() {
    }

    public static <E extends Entity<E>> E create(Class<E> clazz) {
        lastID++;

        E newItem;
        try {
            newItem = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e); // let's hope your child classes will have a working default constructor 
        }
        newItem.ID = lastID;
        return newItem;
    }

    public int getID() {
        return ID;
    }
}

public class Blob extends Entity<Blob> {
    private int x,y;

    public Blob() {
    }

    public void setPos(int X,int Y){;
        x = X;
        y = Y;
    }
}

public class AnotherBlob extends Entity<AnotherBlob> {

    String help = "Help!";

    public String help() {
        return help;
    }

}

// TEST!
public class Test {

    public static void main(String[] args) {
        Blob blob = Entity.create(Blob.class);
        AnotherBlob anotherBlob = Entity.create(AnotherBlob.class);

        System.out.println("Blob: " + blob.getClass() + " ID = " + blob.getID() +
                "\nAnother blob: " + anotherBlob.getClass() + " ID = " + anotherBlob.getID());
    }

}