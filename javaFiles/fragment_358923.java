import mockit.Mock;
import mockit.MockUp;

class Fubar {
    public void delete(String fooId) {
        System.out.println("Called real");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        new MockUp<Fubar>() {
            @Mock
            void delete(final String fooId) {
                System.out.println("Called mock");
            }
        };

        new Fubar().delete("foo123");
    }
}