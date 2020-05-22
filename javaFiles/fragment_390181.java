public class NameComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal arg0, Animal arg1) {

        //null check here
        return arg0.getFName().compareTo(arg1.getFName());
    }

}