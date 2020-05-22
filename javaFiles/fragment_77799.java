public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car entry1, Car entry2) {
        int value;
        if (entry1.getDeliveryDate().before(entry2.getDeliveryDate())){
            value = -1;
        }else if (entry1.getDeliveryDate().equals(entry2.getDeliveryDate())){
            value = 0;
        }else{
            value =1;
        }
        //For same day
        if (value==0){
            if (entry1.getIsReady() > entry2.getIsReady()) {
                value = -1;
            } else if (entry1.getIsReady() < entry2.getIsReady()) {
                value = 1;
            } else if (entry1.getIsReady() == entry2.getIsReady()) {
                value = 0;
            }
        }
        //if same isReady
        if (value==0){
            if (entry1.getGear()!=null && entry2.getGear()==null) {
                value = -1;
            } else  if (entry1.getGear()==null && entry2.getGear()==null) {
                value = 0;
            } else{
                value = 1;
            }
        }
        //if still equals
        if (value==0){
            if (entry1.getTyre()!=null && entry2.getTyre()==null) {
                value = -1;
            } else  if (entry1.getTyre()==null && entry2.getTyre()==null) {
                value = 0;
            } else{
                value = 1;
            }
        }


        return value;
    }
}