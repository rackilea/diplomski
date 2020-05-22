String[] array=new String[list.size()];

    list.toArray(array); //fills array with contents of list

    for(int i=0;i<array.length;i++){
        System.out.println(array[i]);
    }