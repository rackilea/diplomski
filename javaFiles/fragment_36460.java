public void find() {

    int[] array = {5, 3, 4, 2, 3, 4, 5, 7};

    //int counter = 0;
    int min = Integer.MAX_VALUE;
    if(hasDuplicates(array)) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                /*if(array[i] != array[j]){
                    counter++;
                }*/
                if(array[i] == array[j]){
                    min = Math.min(min, j - i);
                }
            }
            //min = min(counter, min);
            /*if (counter > 0)
                min = Math.min(counter, min);
            counter = 0;*/
        }

        System.out.println(min);
    } else {
        System.out.println("-1");
    }
}