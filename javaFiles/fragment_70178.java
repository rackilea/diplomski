import java.util.*;

public class AlphaInsertSort {

public static void main(String[] args) {
    ArrayList<AnyObject> myList = new ArrayList<AnyObject>();
    myList.add(new AnyObject("alphaObj", 44, "blue"));
    myList.add(new AnyObject("betaObj", 7, "orange"));
    myList.add(new AnyObject("gammaObj", 12, "red"));
    myList.add(new AnyObject("omegaObj", 99, "yellow"));
    printList(myList); //helps visualize what's going on
    addElement(new AnyObject("charlieObj", 105, "purple"), myList);
    printList(myList);
    addElement(new AnyObject("aObj", 105, "purple"), myList);
    printList(myList);

    myList.add(new AnyObject("thetaObj", 0, "green"));
    printList(myList);
    addElement(new AnyObject("zetaObj", 2, "pink"), myList);
    printList(myList);
    System.out.println("Finished");
}

public static void addElement(AnyObject element, ArrayList<AnyObject> myList){
    ListIterator<AnyObject> iterator = null;
    //int counter = 1; don't need this
    int compare = 0;
    AnyObject current = myList.get(0); //changed name from first to current and will use this for comparison while iterating
    iterator = myList.listIterator(); //this should set iterator to start of list. There's no constructor for listIterator

    System.out.println("\ncurrent is " + current.toString());

    if(current == null)
        iterator.add(element);
    else
    {

        while(iterator.hasNext())
        {
            //compare = getElement(counter).toString().compareToIgnoreCase(element.toString());
            compare = current.toString().compareToIgnoreCase(element.toString());

            //for display purposes
            System.out.println(current.toString() + " compared to " + element.toString() + " is " + current.toString().compareToIgnoreCase(element.toString()));

            if(compare > 0) { //want to add element into list if compare is negative. Won't necessarily be -1
                iterator.previous(); //will need to move back a spot before adding. Otherwise will always add element after first encountered element that doesn't come before element inserting
                iterator.add(element);
                break; //make sure to break.  No need to continue iterating
            }
            else
            {
                current = iterator.next();
                //counter++;
            }
        }

        //if element is larger than all existing elements in list
        if(!myList.contains(element)) {
            iterator.add(element);
        }
    } 
}

public static void printList(ArrayList<AnyObject> myList) {
    System.out.println("List contents:");
    for(AnyObject element : myList) {
        System.out.println(element.toString());
    }
    System.out.println();
}
}