public class Space {
    public static void main(String[] args) {
        String name = "Richard  rinse ";
        String tname = name.trim().replace("/(\\s\\s+)/g", " ");
        String[] temp;
        temp = name.split(" ");
        String fname = (temp.length > 0) ? temp[0] : null;
        String lname = (temp.length > 1) ? temp[1] : null;
        if (fname != null) System.out.println(fname);
        if (lname != null) System.out.println(lname);
    } else {
        System.out.println("Space does not exists");
    }
}