public class Update {
    private Testing exc;

    public Update(Testing exc) {
        this.exc = exc;
    }

    // this shouldn't be static
    public void server() {
        System.out.println("Hello");
        // Testing exc =new Testing(); // Nope!
        exc.addPanel();  // rename to addPanel to comply with Java naming rules
    }
}