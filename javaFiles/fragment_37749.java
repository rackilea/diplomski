public class StackOverflow {
public void compare(List<String> items, List<List<String>> list){
    String itemToBeCompared=items.get(0);
    for(List<String> l:list){
        if(l.contains(itemToBeCompared)){
            System.out.println("Its Present");
        }
        else{
            System.out.println("Not Present");
        }
    }
}
}