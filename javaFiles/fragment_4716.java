public class CreateCustomerRequest {
    public String fName;
    public String lName;
    public String gender;
    public String address1;
    public String address2;
    public String mobileNo;
}


public static void main(String[] args) throws Throwable {
    List<String> param = new ArrayList<String>();
    param.add("fnameValue");
    param.add("lNameValue");
    param.add("genderValue");
    param.add("address1Value");
    param.add("address2Value");
    param.add("mobileNoValue");
    CreateCustomerRequest object = convert(param, CreateCustomerRequest.class);
    System.out.println("Gender : " + object.gender);
}

public static <T extends Object> T convert(List<String> param, Class<T> clazz) throws Throwable
{
    Constructor<?> ctor = clazz.getConstructor();
    T result = (T) ctor.newInstance();
    Field[] fields = result.getClass().getFields();
    if(fields == null)
        return null;
    for(int i =0;i<fields.length;i++)
    {
        if(fields[i].getType().equals(String.class))
        {
            if(param.size() > i)
                fields[i].set(result, param.get(i));
        }
    }       
    return result;
}