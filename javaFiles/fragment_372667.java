List<T> conditions = ArrayList<>();
    boolean flag = false;
    for(T condition : conditions) {
        try{
            if(!condition)
                flag = false;
        }catch (IndexOutOfBoundsException e){
            //Equivalent command to continue
        }
        if(flag) {
            //do something
        }
    }