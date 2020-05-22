//Add the three choices. Make the ArrayList final so nobody can change it
public static final ArrayList<String> array = new ArrayList<>(); {{
    array.add("0");    
    array.add("1");
    array.add("2");
}}
public static LinkedList<String> linked = new LinkedList<>(); {{
  linked.add("0");
  linked.add("1");
  linked.add("2");
 }}

public String requestElement(){
    /*This function returns the element given to this request, if array has already assigned 2 elements, return "full" */
   String result = "full";  //Assume the result is full
   if(linked.size()==1) {  //If only one time is available return full 
       return result;
   }
   result = linked.poll();    //Poll the first item on the queue
   return result;
}
public String abandonElement(String element){
    /*This function returns the element to be abandoned, if the element doesnt exist, return "not found" */
    String result = "Not Found";
    if(array.contains(element)) {   //If the arrayList contains the element, add it back to the LinkedList
        linked.add(element);
        result = element;
    }
    return result;

}