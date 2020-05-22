public static void main(String[] args) 
    {

        ArrayList<String> arraylist = new ArrayList<>();
        String value,value1,value2;
        value="C";
        value1="Z";
        value2="A";

        arraylist.add(value);
        arraylist.add(value1);
        arraylist.add(value2);
        System.out.println(arraylist);
        Collections.sort(arraylist);
        System.out.println(arraylist);
}