public class Frag_list extends Fragment{

ArrayList<String> list = new ArrayList<String>();
//...

    public void addItem(String data){
        //Add check to avoid problems
        if(list != null) {
            list.add(data);
        }
    }
}