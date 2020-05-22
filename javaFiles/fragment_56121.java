import java.lang.reflect.Method;
import java.lang.reflect.Field;
class DummyClass
{
    public int x;
    public int z;
  public int meathod1()
  {   return 1;
     }
  public int meathod2()
  {    return 2;
      }
  public int method3()
  {    return 3;
    }
}

class MainClass
{
   public static void main(String...s)
   {
      //Step 1: Getting the object of the class whose Fields/method u want to get.

    DummyClass obj=new DummyClass();

   //Step 2. Getting the Class of the class whose field/method u want to get.You can skip Step 1 if u already have Object the class.

     Class myClass=obj.getClass();

    //Step 3.Class has some multiple inbuilt methods to get the methods and Fields of any class.

      Method[] methodList=myClass.getDeclaredMethods();


    /*Now u have all the Methods you have declared in the class.The length of the methodList is the no of declared methods u have in your class.If u want to get the inherited methods too,then use getMethods() instead of getDeclaredMethods(),but then all your methods must be public then because getMethods() returns only public methods.*/
    System.out.println("Total No of Methods : "+methodList.length);

    //Step 4. Class has some other Inbuild methods that return Fields.

    Field[] fieldList=myClass.getDeclaredFields();
    System.out.println("Total no of Fields : "+fieldList.length);
    }
    }