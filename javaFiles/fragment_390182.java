public class SizeComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal arg0, Animal arg1) {

        //null check here

        if(arg0.getSize() == arg1.getSize()){
            return 0;
        }

        return arg0.getSize() > arg1.getSize() ? 1 : -1;
    }

}