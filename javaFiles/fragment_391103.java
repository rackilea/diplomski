class A {
    public static A build(bool someCondition) {
        if (someCondition) {
            return new A1();
        } else {
            return new A2();
        }
    }
}