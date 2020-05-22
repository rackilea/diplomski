class Main {
    public static void main(String[] args) {
        Main main = new Main() {
            {
                System.out.println(toString("XYZ")); // same error
            }  
        };
    }

    class Foo {
        {
            System.out.println(toString("XYZ")); // same error
        }
    }

    private static String toString(String output) {
        return output;
    }
}