public class Department {
    XmlObject obj;

    public Department(XmlObject obj){
        if(!obj instanceof DepartmentType || !obj instanceof OrganizatiopnType){
            throw new IllegalArgumentException();
        }
        this.obj = obj;
    }

    public String getName(){
        return (String)PropertyUtils.getProperty(obj, "name");
    }
}