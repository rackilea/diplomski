public class Test { 
    private final static ArrayList<Integer> values = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
    private final static ArrayList<Integer> children = new ArrayList<>();

    public static void main (String[] args){
        populateList(2); //shift the elements in the list
        System.out.println(children);
        populateListUsingRotate(-2); //get back the original one
        System.out.println(children);
    }

    private static void populateList(int i){
        children.clear();
        for(int p = 0; p < values.size(); p++){
            children.add(values.get(i++%values.size()));
        }
    }

    private static void populateListUsingRotate(int i){
        Collections.rotate(children, -i);
    }
}