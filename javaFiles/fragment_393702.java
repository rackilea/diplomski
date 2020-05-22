class Employee{
    String name;
    String title;
    Employee children[];
    int level;
    String parentName;

    @Override
    public String toString(){
        return "{name =  "+name+" , parent = "+parentName+ ", level = "+level+ " }";
    }
}