public class ListReader {
//numbers.txt has numbers {26, 26, 44, 9, 64, 7, 19, 11, 80, 9}
ArrayList<Integer> nums = new ArrayList<>();
//I will manually put items into list, just to evade creating a file
//You keep doing your thing :)
void addItems() {
    nums.add(26);
    nums.add(26);
    nums.add(44);
    nums.add(9);
    nums.add(64);
    nums.add(7);
    nums.add(19);
    nums.add(11);
    nums.add(80);
    nums.add(9);
}
void removeExtraItems() {
    //Creating a list with extraItems that will be removed further
    ArrayList<Integer> extraItems = new ArrayList<>();
    //Whenever a copy is found from num arrayList - this list gets that copy
    ArrayList<Integer> numsCopy = new ArrayList<>();
    for (int i = 0; i < nums.size(); i++) {
        if(numsCopy.contains(nums.get(i))) {
            extraItems.add(nums.get(i));
        }
        else{numsCopy.add(nums.get(i));
        }
    }
    //for each extraItem, you check the num list backwards - if it finds it , it removes it and break;
    //if you go nums.remove(extraItems.get(i)
    //it will remove the first occurence
    //i guess that you dont want that
    for (int i = 0; i < extraItems.size(); i++) {
        for (int j = nums.size()-1; j >= 0; j--) {
            if(nums.get(j).equals(extraItems.get(i))){
                nums.remove(extraItems.get(i));
                break;
            }
        }
    }
}
//prints list
void printList() {
    for (int i = 0; i < nums.size(); i++) {
        System.out.println(nums.get(i));
    }
}
public static void main(String[] args) {
    ListReader lr = new ListReader();
    lr.addItems();
    lr.removeExtraItems();
    lr.printList();
}