import java.util.ArrayList;
import java.util.List;

public class ObjectCollector {

    static class LstObj {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public LstObj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "LstObj [id=" + id + ", name=" + name + "]";
        }
    }

    public static void main(String[] args) {
        List<LstObj> newlist = new ArrayList<LstObj>();
        List<LstObj> objects = new ArrayList<LstObj>();

        // Populating random objects
        objects.add(new LstObj(1, "Name 1"));
        objects.add(new LstObj(2, "Name 2"));
        objects.add(new LstObj(1, "Name 1"));
        objects.add(new LstObj(1, "Name 1"));
        objects.add(new LstObj(3, "Name 3"));
        objects.add(new LstObj(4, "Name 4"));

        for (LstObj obj : objects) {
            if (obj.getId() == 1) {
                newlist.add(obj);
            }
        }

        System.out.println(newlist);
    }

}