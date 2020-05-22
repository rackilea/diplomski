public String toString() {
    String s = "";
    int indexUsed = 0;
    System.out.println("Inside of toString");
    for(int i = 0; i < indexUsed; i++) 
        s= (s + pizza[i].toString());
        System.out.println("Inside of toString for loop");

    return s;
}