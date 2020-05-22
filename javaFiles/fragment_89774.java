import java.util.ArrayList;

public class recursionEx {
ArrayList<Integer> index = new ArrayList<Integer>();
String string;
recursionEx(String string){this.string = string;}

ArrayList<Integer> indexFinder(int position, String find){
    int pos =0;
    int subPos =0;
    if(string.substring(position).contains(find)==false){
        return index;
    }
    else if(string.substring(position).contains(find)){
        pos = string.substring(position).indexOf(find) + position;
        index.add(pos);
        subPos = pos+find.length();
        return indexFinder(subPos,find);
    }
    return index;
}

public static void main(String[] args) {
    String sent = "Hi is Hi is Hi is";
    String find = "Hi";
    recursionEx r = new recursionEx(sent);
    ArrayList<Integer> g = r.indexFinder(0, find);
    for (Integer pos : g)
        System.out.println(pos);

}

}