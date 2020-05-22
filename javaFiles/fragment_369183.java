public ArrayList<Integer> leftSh(int post, ArrayList<Integer> alist2)
{
    ArrayList<Integer> LeftshifedList = new ArrayList<>(alist2); // create a copy of input List
    for (int i = 1; i <= post; i++) { // remove the first post elements
        LeftshifedList.remove(0); 
    }
    return LeftshifedList;
}