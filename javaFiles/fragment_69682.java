int x;
if(someCondition()) {
    x = 1;
} else {
    // x is not initialized through this code path.
}
System.out.println(x); // x may be initialized here, but it is not guaranteed, so this causes a compile error.