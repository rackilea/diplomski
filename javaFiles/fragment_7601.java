enum Z {
    Z1(new Holder<>(Foo1.class)), Z2(new Holder<>(Foo2.class));
    private final Holder<?> myEnum;

    Z(Holder<?> myEnum) {
        this.myEnum = myEnum;
    }
    Holder<?> getMyEnumHolder() {
        return myEnum;
    }

    static class Holder<T extends Enum<T> & Bar> {
        private final Class<T> myEnum;

        private Holder(Class<T> myEnum) {
            this.myEnum = myEnum;
        }

        Class<T> getMyEnum() {
            return myEnum;
        }
    }
}

class X {
    public static String getMe(Z z, String fooValue) {
        return Enum.valueOf(z.getMyEnumHolder().getMyEnum(), fooValue).getMe();
    }
}