public static Person SearchPersonByID(String id)
{
for(int i=0;i<personList.size();i++)
{
    Person p=new Person();
    p=personList.get(i);
     id=id.trim();
    String useride=id.toString();
    System.out.println(p.UserId.length()+"    compares   "+id.length());
    if(p.UserId.equals(useride))
    {
        System.out.println("Matched");
        return p;   
    }

}return null;

  }