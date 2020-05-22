public class IntArrayBuilder {
    private ArrayList<Integer> list;
    public void addElement(int el) {
        list.add(el);
    }
    public int[] makeArray() {
        int[] array = new int[list.size()];
        for(int i = 0; i < array.length; i++) {
           array[i] = list.get(i);
        }
        return array;
    }
}