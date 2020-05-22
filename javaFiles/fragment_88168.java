@Override
public int compare(Car o1, Car o2) {
    if(o1 == null || o2 == null){
        return -1;
    } else if(o1!=null && o2 == null){
        return -1;
    } else if(o1==null && o2!=null){
        return -1;
    } else{
        if(o1.getCarId() == o2.getCarId() && o1.getManufacturer().equals(o2.getManufacturer())){
            return 0;
        } else {
            return -1;
        }
    }

}