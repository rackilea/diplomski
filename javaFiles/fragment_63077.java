import java.lang.reflect.Field;
import java.util.List;

class Employee{

    private int m=10;
    private int n=20;
    private int o=25;
    private int p=30;
    private int q=40;
}

public class EmployeeTest{

 public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException{

        int sum = 0;
        Employee employee = new Employee();
        Field[] allFields = employee.getClass().getDeclaredFields();

        for (Field each : allFields) {

            if(each.getType().toString().equals("int")){

                Field field = employee.getClass().getDeclaredField(each.getName());
                field.setAccessible(true);

                Object value = field.get(employee);
                Integer i = (Integer) value;
                sum = sum+i;
            }

        }

        System.out.println("Sum :" +sum);
 }

}