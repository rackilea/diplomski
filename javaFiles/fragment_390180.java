public class DogCatComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal arg0, Animal arg1) {


        //null checks here

        if(arg0.sound().equals(arg1.sound())){
            return 0;
        }

        if(arg0.sound().equals("bark") && arg1.sound().equals("meauvvv")){
            return -1;
        }

        return 1;
    }

}