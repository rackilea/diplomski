package utils;

public class ProxyClasses {

    public static class ClassA {
        public void function1(Object arg1, Object arg2, Object arg3) {}
    }
    public static class ClassB {
        public void function1(Object arg1, Object arg2, Object arg3, String username, String password) {}
    }
    public static class ClassC {
        public void function1(Object arg1, Object arg2, Object arg3, String token) {}
    }

    public static interface ClassCommon {
        ProxyClasses function1(Object arg1, Object arg2, Object arg3); // or whatever
    }
    public static class ProxyClass implements ClassCommon {
        @Override
        public void function1(Object arg1, Object arg2, Object arg3) {
            new ClassA().function1(arg1, arg2, arg3);
        }

        public ClassCommon authenticate() {
            return new ClassCommon() {
                @Override
                public void function1(Object arg1, Object arg2, Object arg3) {
                    new ClassA().function1(arg1, arg2, arg3);
                    return this;
                }
            };
        }
        public ClassCommon authenticate(final String username, final String password) {
            ClassB classB = new ClassB();
            classB.login(username, password);
            return new ClassCommon() {
                @Override
                public void function1(Object arg1, Object arg2, Object arg3) {
                    new ClassB().function1(arg1, arg2, arg3, username, password);
                    return this;
                }
            };
        }
        public ClassCommon authenticate(final String token) {
            return new ClassCommon() {
                @Override
                public void function1(Object arg1, Object arg2, Object arg3) {
                    new ClassC().function1(arg1, arg2, arg3, token);
                    return this;
                }
            };
        }
    }
}