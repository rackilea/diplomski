package teeestserrr;

public class two {

    private String name;
    private String age;

    public two(String name, String age){
        this.age = age;
        this.name =  name;
    }

    public String getName(){
        return name;
    }

    public String getAge(){
        return age;
    }


    public String toString(){
        return name + " " + age;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if(name==null){
            return false;
        }
        if(!(obj instanceof two)){
            return false;
        }
        two another = (two)obj;
        return this.name.equals(another.name);
    }

    public int hashCode(){
        return name==null?0:name.hashCode();
    }
}