@Override
public  int compareTo(Object o) {

    Employee obj=(Employee)o;

    if (this.getEsal() > obj.getEsal()){
        return -1;
    }else if (this.getEsal() < obj.getEsal()){
        return 1;
    }else
        return 0;