public class MyArrayList{
public String[] arrays = {};
public int i = 0;

public MyArrayList() {
    arrays = new String[10];
}

public void add(String a)throws ListFullException{ //Add to List if Arraylist is not full
    if(i != arrays.length-1){
    arrays[i] = a;
    i++;
    }
    else{ 
        throw new ListFullException("List Full");
    }
}

public String get(int i){

    return arrays[i];
}

public int getArraySize(){
    return arrays.length;
}
}