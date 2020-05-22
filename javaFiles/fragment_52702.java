import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import auth.UserLevel;
import auth.UserType;

public class UserServiceAccessCheck {
    public static void requestMethods(Class<?> serviceClass, UserType type) {
        System.out.printf("Methods accessible to %s users...%n", type);

        int allowed = 0,
            disallowed = 0,
            count = 0,
            ignore = 0;

        for (Method method : serviceClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(UserLevel.class)) {
                Annotation annotation = method.getAnnotation(UserLevel.class);
                UserLevel level = (UserLevel) annotation;

                if (level.type().getLevel() >= type.getLevel()) {
                    try {
                        method.invoke(serviceClass.newInstance());
                        System.out.printf("  %s - Can access? %-13s - allowed %n", ++count, method.getName());
                        allowed++;
                    } catch (Throwable ex) {
                        System.out.printf("  %s - Can access? %-13s - disallowed: %s %n", ++count, method.getName(), ex.getCause());
                        disallowed++;
                    }
                } else {
                    System.out.printf("  %s - Can access? %-13s - disallowed%n", ++count, method.getName());
                    disallowed++;
                }

            }
        }

        System.out.printf("%nResult : Total : %d, Allowed: %d, Disallowed: %d, Ignore: %d%n%n",
                count, allowed, disallowed, ignore);
    }

    public static void main(String[] args) throws Exception {
        for (UserType type : UserType.values()) {
            requestMethods(ControlService.class, type);
        }
    }
}