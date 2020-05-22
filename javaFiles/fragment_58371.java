import java.lang.reflect.Field;
class Super
{
    public int a ;
    public String name;
    Super(){}
    Super(int a, String name)
    {
        this.a = a;
        this.name = name;
    }
}
class Child extends Super 
{
    public Child(Super other)
    {
        try{
        Class clazz = Super.class;
        Field[] fields = clazz.getFields();//Gives all declared public fields and inherited public fields of Super class
        for ( Field field : fields )
        {
            Class type = field.getType();
            Object obj = field.get(other);
            this.getClass().getField(field.getName()).set(this,obj);
        }
        }catch(Exception ex){ex.printStackTrace();}
    }
    public static void main(String st[])
    {
        Super ss = new Super(19,"Michael");
        Child ch = new Child(ss);
        System.out.println("ch.a="+ch.a+" , ch.name="+ch.name);
    }
}