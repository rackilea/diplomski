String eid;
String ename;
int esal;

public Employee(String eid, String ename, int esal) {
    super();
    this.eid = eid;
    this.ename = ename;
    this.esal = esal;
}

public String getEid() {
    return eid;
}

public String getEname() {
    return ename;
}

public int getEsal() {
    return esal;
}

@Override
public  int compareTo(Object o) {

    Employee obj=(Employee)o;

    if (this.getEsal() < obj.getEsal()){
        return -1;
    }else if (this.getEsal() > obj.getEsal()){
        return 1;
    }else
        return 0;