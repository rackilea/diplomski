public static void main(String[] args) {
    String result = "3;4;7";
    ArrayList<Integer> servs = new ArrayList<Integer>();
    String[] aux = result.split(";");
    for (int i =0; i< aux.length; i++)
    {                       
           servs.add( Integer.parseInt(aux[i]) );                       
    }
    System.out.println("The ArrayList Items "+ servs);
    System.out.println("The size of ArrayList is: " + servs.size());
    System.out.println("The size of the Array is: " + aux.length);
}