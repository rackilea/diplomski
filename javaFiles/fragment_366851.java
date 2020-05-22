public class Tree{
    public String put(String value, int[] path){
        Node current = root;
        for(int i=0;i<path.length;i++){
            if(current.children.get(i)==null){
                current.children.add(i, new Node());
            }
            current = current.children.get(i);
        }
        String ret = current.value;
        current.value = value;
    }
}