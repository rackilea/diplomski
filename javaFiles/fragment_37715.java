public class My3DArray {

    private List<List<List<Object>>> list;

    public My3DArray() {
        this.list = generate3DArray(5, 5, 5);
    }

    public List<List<List<Object>>> generate3DArray(int dim1, int dim2, int dim3) {
        List<List<List<Object>>> list = new ArrayList<List<List<Object>>>();
        for(int i = 0; i < dim1; i++) {
            List<List<Object>> list2 = new ArrayList<List<Object>>();
            for(int j = 0; j < dim2; j++) {
                List<Object> list3 = new ArrayList<Object>(dim3);
                list2.add(list3);
            }
            list.add(list2);
        }
        return list;
    }

    public Object getElementIn3DArray(int i, int j, int k)
        throws NullPointerException, ArrayIndexOutOfBoundsException {
        return list.get(i).get(j).get(k);
    }

    public void setElementIn3DArray(Object o, int i, int j, int k)
        throws NullPointerException, ArrayIndexOutOfBoundsException {
        list.get(i).get(j).add(o);
    }
}

public class Main {
    public static void main(String[] args) {
        My3DArray x = new My3DArray();
        x.setElementIn3DArray("Hello World", 0, 0, 0);
        System.out.println(x.getElementIn3DArray(0, 0, 0));
        System.exit(0);
    }
}