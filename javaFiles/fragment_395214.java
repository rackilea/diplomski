public static void findElemtsThatSumTo( int data[], int k){
    List arrayK[]= new List[k+1];
    for(int i=0; i<arrayK.length; i++)
        arrayK[i]= new ArrayList<Integer>();

    for(int i=0; i<data.length; i++){
        if(data[i]<=k)
            arrayK[data[i]].add(i);
    }

    for(int i=0; i<arrayK.length/2; i++){
        if(!arrayK[i].isEmpty() && !arrayK[k-i].isEmpty())
        {
            for(Object index: arrayK[i])
                for(Object otherIndex: arrayK[k-i])
                    System.out.println("Numbers at indeces ["+index.toString()+", "+otherIndex.toString()+"] add up to "+k+".");
        }
    }

}