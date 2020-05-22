public class ArrayRefVal {
    static class Ref<T> {
        T obj;

        public Ref(T obj) {
            this.obj = obj;
        }

        @Override
        public String toString() {
            return String.valueOf(obj);
        }
    }

    public static void main(String[] args) {        
        ArrayList<Ref<String>> al = new ArrayList<>();
        Ref<String> s = new Ref<>("hiii");
        al.add(s);
        al.get(0).obj = "barg"; 
        System.out.println(s); //prints "barg"
    }
}