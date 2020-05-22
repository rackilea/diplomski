final int METHODS_QUANTITY = 4;
List<Integer> lstIndexes = new ArrayList<Integer>();
for(int i = 1; i <= METHODS_QUANTITY; i++) {
    lstIndexes.add(i);
}
//you can change the condition for the number of times you want to execute it
while(true) {
    Collections.shuffle(lstIndexes);
    for(Integer index : lstIndexes) {
        switch(index) {
            case 1: method1(); break;
            case 2: method2(); break;
            case 3: method3(); break;
            case 4: method4(); break;
        }
    }
}