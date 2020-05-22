public static void selectionSort(String[ ] data){
    // for each position, from 0 up, find the next smallest item
    // and swap it into place
    for(int place=data.length-1; place >= 1; place--){
        int maxIndex= place;
        for(int sweep = place-1; sweep >= 0; sweep--){
            if(data[sweep].compareTo(data[maxIndex]) > 0){
                maxIndex = sweep;
            }
        }
        swap(data, place, maxIndex);
    }