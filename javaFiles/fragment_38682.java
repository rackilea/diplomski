public class ArrayObjects<E> implements SomeImp<E>{

private List<E> list;

private int maxCapacity;

public ArrayObjects(){
    maxCapacity = 10;
    list = new ArrayList<E>();
}

public boolean addObj(E obj){

    if(list.size() == maxCapacity){
        return false;
    }

    list.add(obj);

    return true;
}
}