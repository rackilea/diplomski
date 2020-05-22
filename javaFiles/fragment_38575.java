static ArrayList<ArrayList<Integer>> master = new ArrayList<ArrayList<Integer>>();

public static void generatecombs(int[] x){

    for(int i=1;i<32;i++){

        ArrayList<Integer> writeitem = new ArrayList<Integer>(); // new list to construct each comb
        if((i & 1)>0){          //check if each element is present in combination
            writeitem.add(x[0]);
        }
        if((i & 2)>0){
            writeitem.add(x[1]);
        }
        if((i & 4)>0){
            writeitem.add(x[2]);
        }
        if((i & 8)>0){
            writeitem.add(x[3]);
        }
        if((i & 16)>0){
            writeitem.add(x[4]);
        }

        System.out.printf("The %dth combination is %s\n", i,writeitem);
        master.add(writeitem); //output constructed element
        System.out.printf("The collection so far is: %s\n", master);
    }
}