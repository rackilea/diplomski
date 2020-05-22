public interface GenericReturnTypeList{

    public List<?> getNames();
}

class FirstName implements GenericReturnTypeList{
    String fName;

    public List<?> getNames(){
        return null;
    }
}

class FullName extends FirstName{
    String lName;

    public List<?> getNames(){
        return null;
    }

}

class NameGetter {

    public static void main(String[] args){

        GenericReturnTypeList firstN = new FirstName();
        List<FirstName> firstNList = (List<FirstName>) firstN.getNames();

        GenericReturnTypeList fullN = new FullName();
        List<FullName> fnList = (List<FullName>)fullN.getNames();

    }

}