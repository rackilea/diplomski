import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FieldSaver implements Closeable {

    public static void main(String[] args) throws IOException {
        File f = File.createTempFile("chess-moves-", ".temp");
        try (FieldSaver test = new FieldSaver(f);) {
            for (byte i = 0; i < 100; i++) {
                test.add(new Field(8, new WildBoar(i, i), new Hunter(i, i), new HuntingDog[] {
                        new HuntingDog(i, i),
                        new HuntingDog(i, i),
                        new HuntingDog(i, i) }));
            }

            // Get a few Fields by index
            System.out.println(test.get(0));
            System.out.println(test.get(50));
            System.out.println(test.get(99));

            // EOF exception, there is no Field 100
            // System.out.println(test.get(100));
        }
    }

    private final RandomAccessFile data;

    public FieldSaver(File f) throws FileNotFoundException {
        data = new RandomAccessFile(f, "rw");
    }

    public void add(Field field) throws IOException {
        data.seek(data.length());
        field.write(data);
    }


    public Field get(int index) throws IOException {
        data.seek(index * Field.STORAGE_LENGTH_BYTES);
        return Field.read(data);
    }

    public void close() throws IOException { data.close(); }


    static abstract class Piece {
        protected byte xPos;
        protected byte yPos;

        public Piece(DataInput data) throws IOException {
            xPos = data.readByte();
            yPos = data.readByte();
        }

        public Piece(byte xPos, byte yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        public void write(DataOutput data) throws IOException {
            data.writeByte(xPos);
            data.writeByte(yPos);
        }

        public String toString() { return "[" + xPos + ", " + yPos + "]"; }
    }

    static class Hunter extends Piece {
        public Hunter(byte xPos, byte yPos) { super(xPos, yPos); }
        public Hunter(DataInput data) throws IOException { super(data); }
    }

    static class HuntingDog extends Piece {
        public HuntingDog(byte xPos, byte yPos) { super(xPos, yPos); }
        public HuntingDog(DataInput data) throws IOException { super(data); }
    }

    static class WildBoar extends Piece {
        public WildBoar(byte xPos, byte yPos) { super(xPos, yPos); }
        public WildBoar(DataInput data) throws IOException { super(data); }
    }

    static class Field {
        // size of boar + hunter + 3 dogs
        public static final int STORAGE_LENGTH_BYTES = 2 + 2 + (3 * 2);

        private int size;
        private WildBoar boar;
        private Hunter hunter;
        private final HuntingDog[] dogs;

        public Field(int size, WildBoar wildBoar, Hunter hunter, HuntingDog[] huntingDogs) {
            this.size = size;
            this.boar = wildBoar;
            this.hunter = hunter;
            this.dogs = huntingDogs;
        }

        public String toString() {
            String result = "Wildschwein: " + boar.toString();
            for (HuntingDog dog : dogs) {
                result += "; Hund: " + dog.toString();
            }
            return result + "; Jäger: " + hunter.toString();
        }

        public static Field read(DataInput data) throws IOException {
            WildBoar boar = new WildBoar(data);
            Hunter hunter = new Hunter(data);
            HuntingDog[] dogs = new HuntingDog[3];
            for (int i = 0; i < 3; i++) {
                dogs[i] = new HuntingDog(data);
            }
            return new Field(8, boar, hunter, dogs);
        }

        public void write(DataOutput data) throws IOException {
            boar.write(data);
            hunter.write(data);
            for (HuntingDog dog : dogs) {
                dog.write(data);
            }
        }
    }
}