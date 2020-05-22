public boolean addObj(E obj){

    if(actualSize == maxCapacity){
        return false;
    }

    array[actualSize--] = obj;

    return true;
}