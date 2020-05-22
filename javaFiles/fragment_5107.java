public static Long getMode() {

    long [] num = this.getElements();
    long maxValue=0, maxCount=0; 
    boolean err = false; // New vraible to check if there is an error.
    for (int i = 0; i < num.length; ++i){
        long count = 0;
        for (int j = 0; j < num.length; ++j){
            if (num[j] == num[i])
                ++count;
        }
        if(count==maxCount && maxValue!=num[i]){ // if there are two modes
            err=true; // then set err to true.
        }else if (count > maxCount){
            maxCount = count;
            maxValue = num[i];
            err = false; // If valid mode is found, then set err to false.
        }
        System.out.println(err);
    }
    return err ? -1 : maxValue; // return value if err is false, else return -1
}