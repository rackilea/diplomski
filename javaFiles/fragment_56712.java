public class ReferenceTester {

    public static void main(final String[] args) {
        final String original = "The One and only one";
        final List<String> list = new ArrayList<String>();
        list.add(original);
        final String copy = list.get(0);
        if (original == copy) {
            System.out.println("Whoops, these are actually two references to the same object.");
        } else {
            System.out.println("References to a different objects? A copy?");
        }
    }

}