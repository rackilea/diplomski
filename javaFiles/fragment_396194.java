import java.lang.reflect.Field;
import java.security.Permission;

public class UseReflection {
    static{
        try {
            System.setSecurityManager(new MySecurityManager());
        } catch (SecurityException se) {
            System.out.println("SecurityManager already set!");
        }

    }
    public static void main(String args[]) {
        Object prey = new Prey();
        try {
            Field pf = prey.getClass().getDeclaredField("privateString");
            pf.setAccessible(true);
            pf.set(prey, "Aminur test");
            System.out.println(pf.get(prey));
        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }

    }
}

class Prey {
    private String privateString = "privateValue";
}

class MySecurityManager extends SecurityManager {
     public void checkPermission(Permission perm) {
         if(perm.getName().equals("suppressAccessChecks")){
             throw new SecurityException("Can not change the permission dude.!");
         }

     }
}