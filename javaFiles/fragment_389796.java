if (someConditionIsTrue) try {
    MyClass();  // Count 1
    MyClass();  // Count 2
} finally {
    MyClass.staticReset();
}