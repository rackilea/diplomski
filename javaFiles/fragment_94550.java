public static void main(String[] args) {
    List<foo> myList = new ArrayList<foo>();

    String nValue = getFromUser();
    int pos = getPosition(myList, nValue);//<-------Get position in your List
    foo f = new foo(nValue, 1);
    if (pos == -1) {//if your object not exist create it and add it to your List
        myList.add(new foo(nValue, 1));
    } else {//else increment your counter
        myList.get(pos).setCount(myList.get(pos).getCount() + 1);
    }
}

private static int getPosition(List<foo> myList, String nValue) {
    for (int i = 0; i < myList.size(); i++) {
        if (myList.get(i).getVal().equals(nValue)) {
            return i;
        }
    }
    return -1;
}