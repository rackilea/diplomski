someArray[] array = [
    [[1234,245,10],[312,234,122],[1234,67788,345],[235,001,332]],
    [[1234,245,10],[312,234,122],[1234,67788,345],[235,001,332],[1234,67788,3450]],
    [[1234,245,10],[312,234,122],[1234,67788,345],[235,001,332],[1234,67788,34534]]]


    JSONArray superMasterArray = new JSONArray(array);
    if(superMasterArray != null){
        for(int i = 0; i < superMasterArray.length(); i++ ){
        JSONArray masterArray = (JSONArray) superMasterArray.get(i);
            for(int j = 0; j< masterArray.length(); j++){
                 JSONArray innerArray = (JSONArray) masterArray.get(j);
                 innerArray.getint(0);// gives 1st element of the inner array that is 1234
                 innerArray.getint(1);// gives 245
                 innerArray.getint(2);// gives 10
// if you dont know how many element in the given array, then loop it with size of array 
                }
            }
    }