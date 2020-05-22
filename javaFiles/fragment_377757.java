public void swapPairs(int [] array){
    for(int i = 0; i < array.length(); i += 2){
        if(i != array.length - 1)
        System.out.print(array[i] + " " + array[i+1]);
    }
if(array.length % 2 == 1) System.out.print(" " + array[array.length - 1]);