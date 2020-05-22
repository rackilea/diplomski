function myFunction() {
    // do stuff
    if(someCondition) {
        myFunction(); // this is the recursion
    }
}
for(int i = 0; i < 30; i++) {
    myFunction();
}